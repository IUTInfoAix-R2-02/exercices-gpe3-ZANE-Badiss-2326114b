package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;

    private Scene scn ;

    private Label label;
    private HBox haut;
    private Pane panneau;
    private HBox bas;

    private void handleButonClick(Event event) {
        panneau.setStyle("-fx-background-color:rgba(0,255, 0, 0.5)");
        nbVert = nbVert + 1;
        label.setText( "Le Vert a été appuyé " +nbVert+ " fois" );

    }private void handleBtonClick(Event event) {
        panneau.setStyle("-fx-background-color:rgba(255,0, 0, 0.5)");
        nbRouge = nbRouge + 1;
        label.setText( "Le Rouge a été appuyé " +nbRouge+ " fois" );

    }private void handleBonClick(Event event) {
        panneau.setStyle("-fx-background-color:rgba(0,0, 255, 0.5)");
        nbBleu = nbBleu + 1;
        label.setText( "Le Bleu a été appuyé " +nbBleu+ " fois" );
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();

        this.root = new BorderPane();
        this.haut = new HBox();


        this.label = new Label();
        haut.getChildren().addAll( label);
        haut.setAlignment( Pos.CENTER );
        root.setTop(haut);




        this.panneau = new Pane();
        root.setCenter(panneau);

        this.vert = new Button("Vert");
        this.rouge = new Button("Rouge");
        this.bleu = new Button("Bleu");

        this.bas = new HBox();

        bas.getChildren().addAll( vert, rouge, bleu );
        bas.setAlignment( Pos.BOTTOM_CENTER);




        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> handleButonClick(actionEvent) );
        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> handleBtonClick(actionEvent) );
        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> handleBonClick(actionEvent) );

        root.setBottom(bas);

        this.scn = new Scene(root);
        primaryStage.setScene( scn );

        primaryStage.setTitle("Palette");
        primaryStage.show();
        primaryStage.setWidth(400);
        primaryStage.setHeight(200);

    };
}

