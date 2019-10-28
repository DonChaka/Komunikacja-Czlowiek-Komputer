package sample;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

public class Controller
{
    @FXML Label infoLabel;
    @FXML ToggleButton toggleButton;

    public Controller(){}


    Controller(Parent root)
    {
        this.infoLabel = (Label) root.lookup("infoLabel");
        this.toggleButton = (ToggleButton) root.lookup("toggleButton");
    }

    private String[] stany = {"On", "Off"};
    private boolean stan = true;

    public void toggle()
    {
        stan = !stan;
        infoLabel.setText(stany[stan ? 1 : 0]);
    }

}
