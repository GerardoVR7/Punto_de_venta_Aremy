package Controllers.AdminControllers.UsersControllers;

import DAOS.UsuariosDAO;
import Model.Producto;
import Model.Usuario;
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

public class UsersController implements Initializable {

    UsuariosDAO usuariosDAO = new UsuariosDAO();

    @FXML
    private Button editUserB;

    @FXML
    private Button deleteUserB;

    @FXML
    void deleteUser(ActionEvent event) {
        Main.popUp("Usuario/deleteUser","Asistente de Gestion de Usuarios");

    }

    @FXML
    void editUser(ActionEvent event) {
        Main.popUp("Usuario/editUser","Asistente de Gestion de Usuarios");
    }

    @FXML
    private TableView<Usuario> tableView;

    @FXML
    private TableColumn<Usuario, ?> idUsuario;

    @FXML
    private TableColumn<Usuario, ?> nombre;

    @FXML
    private TableColumn<Usuario, ?> contrasena;

    @FXML
    private TableColumn<Usuario, ?> rol;

    @FXML
    private void data(){

        tableView.getColumns().clear();

        idUsuario.setCellValueFactory(
                new PropertyValueFactory<>("idUsuario")
        );
        nombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre")
        );
        contrasena.setCellValueFactory(
                new PropertyValueFactory<>("contrasena")
        );
        rol.setCellValueFactory(
                new PropertyValueFactory<>("rol")
        );

        tableView.getColumns().add(idUsuario);
        tableView.getColumns().add(nombre);
        tableView.getColumns().add(contrasena);
        tableView.getColumns().add(rol);

        tableView.setItems(usuariosDAO.getUsuario());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        data();
    }

}
