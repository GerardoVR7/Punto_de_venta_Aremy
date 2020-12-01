package Controllers.AdminControllers.AlmacenControllers;

import DAOS.ProductosDAO;
import Model.Producto;
import Model.Proveedor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class AlmacenController implements Initializable {

    ProductosDAO productosDAO = new ProductosDAO();

    @FXML
    private Button editProductB;

    @FXML
    private Button deleteProductB;

    @FXML
    private Button addProductB;

    @FXML
    void addProduct(ActionEvent event) {
        Main.popUp("Almacen/addProduct","Asistente de gestion de Productos");
    }

    @FXML
    void deleteProduct(ActionEvent event) {
        Main.popUp("Almacen/deleteProduct","Asistente de gestion de Productos");
    }

    @FXML
    void editProduct(ActionEvent event) {
        Main.popUp("Almacen/editProduct","Asistente de gestion de Productos");
    }

    @FXML
    private TableView<Producto> tableView;

    @FXML
    private TableColumn<Producto, ?> idProducto;

    @FXML
    private TableColumn<Producto, ?> nombre;

    @FXML
    private TableColumn<Producto, ?> precio;

    @FXML
    private TableColumn<Producto, ?> stock;

    @FXML
    private TableColumn<Producto, ?> nombreProveedor;

    @FXML
    private void data(){

        tableView.getColumns().clear();

        idProducto.setCellValueFactory(
                new PropertyValueFactory<>("idProducto")
        );
        nombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre")
        );
        precio.setCellValueFactory(
                new PropertyValueFactory<>("precio")
        );
        stock.setCellValueFactory(
                new PropertyValueFactory<>("stock")
        );
        nombreProveedor.setCellValueFactory(
                new PropertyValueFactory<>("proveedor")
        );

        tableView.getColumns().add(idProducto);
        tableView.getColumns().add(nombre);
        tableView.getColumns().add(precio);
        tableView.getColumns().add(stock);
        tableView.getColumns().add(nombreProveedor);

        tableView.setItems(productosDAO.getProducto());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        data();
    }

}