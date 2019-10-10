package Main;

import Encryption.Enigma;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{

    private static Enigma enigma;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
        Controller controller = new Controller(root);

        enigma = new Enigma(1,2,3);

        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root, 530, 902);
        scene.setOnKeyPressed(event -> {
            char x = event.getText().charAt(0);
            enigma.tickRotors();
            System.out.println("Pressed: " + x);
            System.out.println(enigma.encrypt(x));
        });

        scene.setOnKeyReleased(event -> {
            enigma.printRotors();
        });
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
