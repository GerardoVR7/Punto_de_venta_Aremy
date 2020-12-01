package Controllers.AdminControllers.AlmacenControllers;

import DAOS.ProductosDAO;
import DAOS.ProveedoresDAO;
import Model.Producto;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class addProductController implements Initializable {

    ProveedoresDAO proveedoresDAO = new ProveedoresDAO();
    ProductosDAO productosDAO = new ProductosDAO();

    @FXML
    private TextField idProducto;

    @FXML
    private TextField nombreProducto;

    @FXML
    private TextField precioProducto;

    @FXML
    private TextField stock;

    @FXML
    private ComboBox<String> choice;

    @FXML
    private Button saveB;

    @FXML
    private Button cancelB;

    @FXML
    void cancel(ActionEvent event) {
        Main.getPopUp().close();
    }

    @FXML
    void save(ActionEvent event) {

        Producto producto = new Producto(Integer.parseInt(idProducto.getText()), nombreProducto.getText(),
                Float.parseFloat(precioProducto.getText()), Integer.parseInt(stock.getText()), choice.getValue());

        productosDAO.setProducto(producto);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        choice.getItems().addAll(FXCollections.observableArrayList(proveedoresDAO.getNombresProveedores()));

    }

}
