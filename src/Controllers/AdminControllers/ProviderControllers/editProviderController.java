package Controllers.AdminControllers.ProviderControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Main;

public class editProviderController {

    @FXML
    private TextField nameText;

    @FXML
    private Button cancelB;

    @FXML
    private Button saveB;

    @FXML
    void cancel(ActionEvent event) {
        Main.getPopUp().close();
    }

    @FXML
    void save(ActionEvent event) {

    }

}
