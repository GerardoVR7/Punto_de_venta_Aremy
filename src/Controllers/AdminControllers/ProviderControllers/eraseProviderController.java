package Controllers.AdminControllers.ProviderControllers;

import DAOS.ProveedoresDAO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import sample.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class eraseProviderController implements  Initializable {

    ProveedoresDAO proveedoresDAO = new ProveedoresDAO();

    @FXML
    private Text nameProvider;

    @FXML
    private Button cancelB;

    @FXML
    private Button borrarB;

    @FXML
    void cancel(ActionEvent event) {
        Main.getPopUp().close();
    }

    @FXML
    private ChoiceBox<Integer> choice;

    @FXML
    void borrar(ActionEvent event) {

        proveedoresDAO.deletedProveedor(choice.getValue());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        choice.getItems().addAll(FXCollections.observableArrayList(proveedoresDAO.getDatosProveedores()));

    }

}
