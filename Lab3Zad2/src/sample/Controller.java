package sample;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

import java.awt.event.ActionEvent;

public class Controller
{
    @FXML ToggleButton tog1;
    @FXML ToggleButton tog2;
    @FXML ToggleButton tog3;
    @FXML ToggleButton tog4;

    @FXML Button open;
    @FXML Button close;

    @FXML Label infoLabel;

    public Controller(){}

    Controller(Parent root)
    {
        this.infoLabel = (Label) root.lookup("infoLabel");
        this.open = (Button) root.lookup("open");
        this.close = (Button) root.lookup("close");
        this.tog1 = (ToggleButton) root.lookup("tog1");
        this.tog2 = (ToggleButton) root.lookup("tog2");
        this.tog3 = (ToggleButton) root.lookup("tog3");
        this.tog4 = (ToggleButton) root.lookup("tog4");
    }

    public void switchButtons(javafx.event.ActionEvent actionEvent)
    {
        infoLabel.setText(((ToggleButton)actionEvent.getSource()).getText());
    }

}
