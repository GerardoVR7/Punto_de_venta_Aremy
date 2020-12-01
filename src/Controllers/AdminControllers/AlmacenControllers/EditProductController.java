package Controllers.AdminControllers.AlmacenControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sample.Main;

public class EditProductController {

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
