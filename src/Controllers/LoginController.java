package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Main;

public class LoginController {

    @FXML
    private Button loginCajero;

    @FXML
    private Button loginAdmin;

    @FXML
    private Button addUserB;

    @FXML
    void LoginAdmin(ActionEvent event) {
        Main.popUp("Admin","Administrador");

    }

    @FXML
    void LoginCajero(ActionEvent event) {
        Main.popUp("Cajero","Cajero");

    }

    @FXML
    void addUser(ActionEvent event) {
        Main.popUp("Usuario/addUser","Registro de Usuarios");

    }


}