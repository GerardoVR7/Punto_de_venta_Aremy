package Controllers.AdminControllers;

import DAOS.ProveedoresDAO;
import Model.Proveedor;
import javafx.collections.ObservableList;
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

public class ProvidersController implements Initializable {

    ProveedoresDAO proveedoresDAO = new ProveedoresDAO();

    @FXML
    private Button addProviderB;

    @FXML
    private Button editProviderB;

    @FXML
    private Button eraseProviderB;

    @FXML
    private Button volverB;

    @FXML
    void addProvider(ActionEvent event) {

        Main.popUp("/Proveedor/addProveedor","Gestor de Proveedores");
    }

    @FXML
    void editProvider(ActionEvent event) {
        Main.popUp("/Proveedor/editProveedor","Gestor de Proveedores");
    }

    @FXML
    void eraseProvider(ActionEvent event) {
        Main.popUp("/Proveedor/eraseProveedor","Gestor de Proveedores");
    }

    @FXML
    void volver(ActionEvent event) {
        Main.getPopUp().close();
    }

    @FXML
    private TableView<Proveedor> tableView;

    @FXML
    private TableColumn<Proveedor, ?> idProveedor;

    @FXML
    private TableColumn<Proveedor, ?> nombre;


    @FXML
    private void data(){

        tableView.getColumns().clear();

        idProveedor.setCellValueFactory(
                new PropertyValueFactory<>("idProveedor")
        );
        nombre.setCellValueFactory(
                new PropertyValueFactory<>("nombreProveedor")
        );

        tableView.getColumns().add(idProveedor);
        tableView.getColumns().add(nombre);

        tableView.setItems(proveedoresDAO.getProveedor());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        data();
    }

}
