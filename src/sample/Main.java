package sample;

import Adapters.MariaDBadapter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


import javax.imageio.spi.ServiceRegistry;
import java.io.IOException;


public class Main extends Application {
    private static  Scene scene;
    private static Stage primaryStage;
    private static Stage popUp;
    private static ServiceRegistry serviceRegistry;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        MariaDBadapter mariaDBadapter = new MariaDBadapter();
        mariaDBadapter.Connection();
        try {

            Parent root = FXMLLoader.load(getClass().getResource("../View/Login.fxml"));
            scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Jardineria");
            primaryStage.sizeToScene();
            primaryStage.centerOnScreen();
            primaryStage.setResizable(false);
            primaryStage.show();


        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void setFXML(String fxml, String title) throws IOException {
        scene.setRoot(loadFXML(fxml));
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.setTitle(title);
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("../view/"+ fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void popUp(String fxml, String title) {
        try {
            Parent node = loadFXML(fxml);
            popUp = new Stage();
            Scene scene = new Scene(node);
            popUp.setScene(scene);
            popUp.setTitle(title);
            popUp.initOwner(primaryStage);
            popUp.initModality(Modality.WINDOW_MODAL);
            popUp.centerOnScreen();
            popUp.show();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Stage getPopUp(){
        return popUp;
    }
}

