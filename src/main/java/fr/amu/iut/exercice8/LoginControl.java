package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {

    @FXML
    PasswordField pwd = new PasswordField();

    @FXML
    TextField userid = new TextField();

    @FXML
    private void okClicked() {
        System.out.println(userid.getText());
        String chaine = new String("");
       for(int i=0; i<pwd.getLength(); i+=1 ){
           chaine += "*";
       }
       System.out.print(chaine);
    }

    @FXML
    private void cancelClicked() {
        userid.clear();
        pwd.clear();
    }
}