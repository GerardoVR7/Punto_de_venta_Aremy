package Controllers.AdminControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Main;

public class AdminController {

    @FXML
    private Button almacenButton;

    @FXML
    private Button ventasB;

    @FXML
    private Button usuariosB;

    @FXML
    private Button providersB;
    @FXML
    private Button backB;

    @FXML
    void back(ActionEvent event) {
        Main.getPopUp().close();
    }

    @FXML
    void showAlmacen(ActionEvent event) {
        Main.popUp("Almacen","Almacen");
    }

    @FXML
    void showProviders(ActionEvent event) {
        Main.popUp("Providers","Proveedores");
    }

    @FXML
    void showSells(ActionEvent event) {
        Main.popUp("Sells","Ventas");

    }

    @FXML
    void showUsers(ActionEvent event) {
        Main.popUp("Users","Usuarios");
    }


}