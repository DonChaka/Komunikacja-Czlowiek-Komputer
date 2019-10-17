package com.Main;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;;
import javafx.scene.control.Control;
import javafx.scene.media.AudioClip;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Controller
{
    @FXML private Pane paneFX;

    @FXML private Button QButton;
    @FXML private Button WButton;
    @FXML private Button EButton;
    @FXML private Button RButton;
    @FXML private Button TButton;
    @FXML private Button ZButton;
    @FXML private Button UButton;
    @FXML private Button IButton;
    @FXML private Button OButton;
    @FXML private Button AButton;
    @FXML private Button SButton;
    @FXML private Button DButton;
    @FXML private Button FButton;
    @FXML private Button GButton;
    @FXML private Button HButton;
    @FXML private Button JButton;
    @FXML private Button KButton;
    @FXML private Button PButton;
    @FXML private Button YButton;
    @FXML private Button XButton;
    @FXML private Button CButton;
    @FXML private Button VButton;
    @FXML private Button BButton;
    @FXML private Button NButton;
    @FXML private Button MButton;
    @FXML private Button LButton;

    @FXML private Label Rotor1Label;
    @FXML private Label Rotor2Label;
    @FXML private Label Rotor3Label;

    @FXML private Slider Rotor1Slider;
    @FXML private Slider Rotor2Slider;
    @FXML private Slider Rotor3Slider;

    private static List<ImageView> imageViewArray = new ArrayList<>();
    private AudioClip clip;

    private static boolean buttonPressed = false;

    public Controller() { }

    public void initialize() {
        URL resource = getClass().getResource("tik.wav");
        this.clip = new AudioClip(resource.toString());

        this.Rotor1Slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                if(!buttonPressed) {
                    Main.enigma.getRotor1().setPosition(new_val.intValue() - 65);
                    Rotor1Label.setText(String.valueOf((char) (new_val.intValue())));
                    clip.play();
                }
            }
        });

        this.Rotor2Slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                if(!buttonPressed) {
                    Main.enigma.getRotor2().setPosition(new_val.intValue() - 65);
                    Rotor2Label.setText(String.valueOf((char) (new_val.intValue())));
                    clip.play();
                }
            }
        });

        this.Rotor3Slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                if(!buttonPressed) {
                    Main.enigma.getRotor3().setPosition(new_val.intValue() - 65);
                    Rotor3Label.setText(String.valueOf((char) (new_val.intValue())));
                    clip.play();
                }
            }
        });
    }

    Controller(Parent root) {
        this.paneFX = (Pane) root.lookup("#paneFX");

        for(int ASCIIchar = 65; ASCIIchar <= 90; ASCIIchar++)
            imageViewArray.add((ImageView) paneFX.lookup("#" + (char)ASCIIchar + "Led"));

        System.out.println(imageViewArray.size());

        this.QButton = (Button) paneFX.lookup("#QButton");
        this.WButton = (Button) paneFX.lookup("#WButton");
        this.EButton = (Button) paneFX.lookup("#EButton");
        this.RButton = (Button) paneFX.lookup("#RButton");
        this.TButton = (Button) paneFX.lookup("#TButton");
        this.ZButton = (Button) paneFX.lookup("#ZButton");
        this.UButton = (Button) paneFX.lookup("#UButton");
        this.IButton = (Button) paneFX.lookup("#IButton");
        this.OButton = (Button) paneFX.lookup("#OButton");
        this.AButton = (Button) paneFX.lookup("#AButton");
        this.SButton = (Button) paneFX.lookup("#SButton");
        this.DButton = (Button) paneFX.lookup("#DButton");
        this.FButton = (Button) paneFX.lookup("#FButton");
        this.GButton = (Button) paneFX.lookup("#GButton");
        this.HButton = (Button) paneFX.lookup("#HButton");
        this.JButton = (Button) paneFX.lookup("#JButton");
        this.KButton = (Button) paneFX.lookup("#KButton");
        this.PButton = (Button) paneFX.lookup("#PButton");
        this.YButton = (Button) paneFX.lookup("#YButton");
        this.XButton = (Button) paneFX.lookup("#XButton");
        this.CButton = (Button) paneFX.lookup("#CButton");
        this.VButton = (Button) paneFX.lookup("#VButton");
        this.BButton = (Button) paneFX.lookup("#BButton");
        this.NButton = (Button) paneFX.lookup("#NButton");
        this.MButton = (Button) paneFX.lookup("#MButton");
        this.LButton = (Button) paneFX.lookup("#LButton");

        this.Rotor1Label = (Label) paneFX.lookup("#Rotor1");
        this.Rotor2Label = (Label) paneFX.lookup("#Rotor2");
        this.Rotor3Label = (Label) paneFX.lookup("#Rotor3");

        this.Rotor1Slider = (Slider) paneFX.lookup("#Rotor1Slider");
        this.Rotor2Slider = (Slider) paneFX.lookup("#Rotor2Slider");
        this.Rotor3Slider = (Slider) paneFX.lookup("#Rotor3Slider");
    }

    /*void setCryptedLetter(char x)
    {
        testLabel.setText(Character.toString(x));
    }*/

    @FXML public void keyPressed(MouseEvent e) {
        buttonPressed = !buttonPressed;
        Main.enigma.tickRotors();
        System.out.println("Pressed " + ((Control)e.getSource()).getId().replaceFirst("Button", ""));
        this.Rotor1Label.setText(String.valueOf((char)(Main.enigma.getRotor1().getPosition() + 65)));
        this.Rotor1Slider.setValue(Main.enigma.getRotor1().getPosition() + 65);
        this.Rotor2Label.setText(String.valueOf((char)(Main.enigma.getRotor2().getPosition() + 65)));
        this.Rotor2Slider.setValue(Main.enigma.getRotor2().getPosition() + 65);
        this.Rotor3Label.setText(String.valueOf((char)(Main.enigma.getRotor3().getPosition() + 65)));
        this.Rotor3Slider.setValue(Main.enigma.getRotor3().getPosition() + 65);
        System.out.println((char)(Main.enigma.encrypt(((Control)e.getSource()).getId().replaceFirst("Button", "").charAt(0))-32));
        imageViewArray.get((Main.enigma.encrypt(((Control)e.getSource()).getId().replaceFirst("Button", "").charAt(0))-32)-65).setVisible(true);
    }

    @FXML public void keyUnpressed(MouseEvent e) {
        buttonPressed = !buttonPressed;
        System.out.println("Unpressed " + ((Control)e.getSource()).getId().replaceFirst("Button", ""));
        imageViewArray.get((int) (Main.enigma.encrypt(((Control)e.getSource()).getId().replaceFirst("Button", "").charAt(0))-32)-65).setVisible(false);
    }
}