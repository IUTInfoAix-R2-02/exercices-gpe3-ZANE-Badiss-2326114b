package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class IHMPendu extends Application {

    private Scene scene;
    private BorderPane root;

    TextField tf = new TextField();



    Dico dico = new Dico();
    String mot = dico.getMot();

    Label lb = new Label(mot);



    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);

        root = new BorderPane();


        for(int i=0;i < lb.();)

        root.setCenter(lb);
        root.setBottom(tf);
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }





    public static void main(String[] args) {
        launch(args);
    }
}
