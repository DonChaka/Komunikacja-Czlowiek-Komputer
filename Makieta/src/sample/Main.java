package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Zad3.fxml"));
        primaryStage.setTitle("Zmiana wielkości liter");
        primaryStage.setScene(new Scene(root, 460  , 245));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
