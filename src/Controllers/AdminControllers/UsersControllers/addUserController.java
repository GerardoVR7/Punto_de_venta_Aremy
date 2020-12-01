package Controllers.AdminControllers.UsersControllers;

import DAOS.UsuariosDAO;
import Model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import sample.Main;

public class addUserController {

    UsuariosDAO usuariosDAO = new UsuariosDAO();

    @FXML
    private TextField idUsuario;

    @FXML
    private TextField nombre;

    @FXML
    private TextField contrasena;

    @FXML
    private TextField rol;

    @FXML
    private Button registerB;

    @FXML
    private Button cancelB;

    @FXML
    private ComboBox<?> rolUser;

    @FXML
    void Cancel(ActionEvent event) {
        Main.getPopUp().close();
    }

    @FXML
    void Register(ActionEvent event) {

        Usuario usuario = new Usuario(Integer.parseInt(idUsuario.getText()), nombre.getText(), contrasena.getText(),rol.getText());
        usuariosDAO.setUsuario(usuario);

    }



}