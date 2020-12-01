package Controllers.AdminControllers.AlmacenControllers;

import DAOS.ProductosDAO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class DeleteProductController implements Initializable {

    ProductosDAO productosDAO = new ProductosDAO();

    @FXML
    private ComboBox<Integer> choice;


    @FXML
    private  Label nombre;

    /*@FXML
    private Label id;

    @FXML
    private Label nombre;

    @FXML
    private Label precio;

    @FXML
    private Label stock;

    @FXML
    private Label proveedor;
*/
    @FXML
    private Button searchB;

    @FXML
    private Button eraseB;

    @FXML
    private Button cancelB;



    @FXML
    void cancel(ActionEvent event) {
        Main.getPopUp().close();
    }

    @FXML
    void search(ActionEvent event){


        /*for (int i=0; i<productosDAO.getlistaProductos().size(); i++){

            String nombreBuscado = choice.getValue();
            String nombreABuscar = productosDAO.getlistaProductos().get(i).getNombre();

            if (nombreBuscado.equals(nombreABuscar)){
                id.setText(String.valueOf( productosDAO.getlistaProductos().get(i).getIdProducto()));
                nombre.setText(productosDAO.getlistaProductos().get(i).getNombre());
                precio.setText(String.valueOf(productosDAO.getlistaProductos().get(i).getPrecio()));
                stock.setText(String.valueOf(productosDAO.getlistaProductos().get(i).getStock()));
                proveedor.setText(productosDAO.getlistaProductos().get(i).getProveedor());
            }
        }*/

        for(int i=0; i<productosDAO.getlistaProductos().size(); i++){
           if( productosDAO.getlistaProductos().get(i).getIdProducto() == choice.getValue()){
               nombre.setText(productosDAO.getlistaProductos().get(i).getNombre());
           }
        }

    }


    @FXML
    void erase(ActionEvent event) {

        productosDAO.deletedProveedor(choice.getValue());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        choice.getItems().addAll(FXCollections.observableArrayList(productosDAO.getNombresProductos()));

    }

}
