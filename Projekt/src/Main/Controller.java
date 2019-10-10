package Main;

import javafx.fxml.FXML;

import java.awt.*;

public class Controller
{
    @FXML
    private
    Label testLabel;

    void setCryptedLetter(char x)
    {
        testLabel.setText(Character.toString(x));
    }


}