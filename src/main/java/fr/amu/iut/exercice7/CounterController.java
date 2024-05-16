package fr.amu.iut.exercice7;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class CounterController implements Initializable {

    int counter = 0;

    @FXML
    Label counterLabel = new Label("0");

    @FXML
    Button decrementButton = new Button("decrementButton");

    @FXML
    Button incrementButton = new Button("incrementButton");

    public void increment() {
        counter +=1;
        counterLabel.setText(String.valueOf(counter));
    }

    public void decrement() {
        counter -=1;
        counterLabel.setText(String.valueOf(counter));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing CounterController...");

   }
}
