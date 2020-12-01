package Controllers.AdminControllers.ProviderControllers;

import DAOS.ProveedoresDAO;
import Model.Proveedor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Main;

public class addProviderController {

    ProveedoresDAO proveedoresDAO = new ProveedoresDAO();

    @FXML
    private TextField nombreProvedor;

    @FXML
    private TextField idProvedor;

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

        Proveedor proveedor = new Proveedor(Integer.parseInt(idProvedor.getText()),nombreProvedor.getText());
        proveedoresDAO.setProveedor(proveedor);

    }





}