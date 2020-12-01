package Controllers.AdminControllers.UsersControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import sample.Main;

public class editUserController {

    @FXML
    private ComboBox<?> iduser;

    @FXML
    private TextField nombreUsuarioTetxt;

    @FXML
    private TextField passwordText;

    @FXML
    private ComboBox<?> rol;

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

    }


}
