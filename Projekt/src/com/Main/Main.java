package com.Main;

import com.Encryption.Enigma;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application
{

    static Enigma enigma;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));

        Controller controller = new Controller(root);

        enigma = new Enigma(1,2,3);

        primaryStage.setTitle("Enigma");
        Scene scene = new Scene(root, 530, 902);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
