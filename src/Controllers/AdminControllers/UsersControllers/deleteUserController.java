package Controllers.AdminControllers.UsersControllers;

import DAOS.UsuariosDAO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class deleteUserController implements Initializable {

    UsuariosDAO usuariosDAO = new UsuariosDAO();

    @FXML
    private ComboBox<Integer> idUser;

    @FXML
    private Button cancelB;

    @FXML
    private Button deleteB;

    @FXML
    void cancel(ActionEvent event) {
        Main.getPopUp().close();
    }

    @FXML
    void delete(ActionEvent event) {

        usuariosDAO.deletedUsuario(idUser.getValue());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        idUser.getItems().addAll(FXCollections.observableArrayList(usuariosDAO.getDatosUsuarios()));

    }

}
