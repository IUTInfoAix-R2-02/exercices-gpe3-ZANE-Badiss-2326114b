package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import static javafx.beans.binding.Bindings.when;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Label texteDuHaut;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;

    private Label texteDuBas;

    private IntegerProperty nbFois;

    private StringProperty message;

    private StringProperty couleurPanneau;

    private StringProperty clr;

    public String getClr() {
        return clr.get();
    }

    public StringProperty clrProperty() {
        return clr;
    }

    public void setClr(String clr) {
        this.clr.set(clr);
    }

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);
        couleurPanneau = new SimpleStringProperty("#000000");

        nbFois= new SimpleIntegerProperty();

        message = new SimpleStringProperty();
        clr = new SimpleStringProperty("#000000");
        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");
        createBindings();
        rouge.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setMessage(rouge.getText());
                nbRouge++;
                setNbFois(nbRouge);
                setCouleurPanneau("-fx-background-color: red;");
                setClr("-fx-text-fill: red;");
            }
        });
        bleu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setMessage(bleu.getText());
                nbBleu++;
                setNbFois(nbBleu);
                setCouleurPanneau("-fx-background-color: blue;");
                setClr("-fx-text-fill: blue;");
            }
        });
        vert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setMessage(vert.getText());
                nbVert++;
                setNbFois(nbVert);
                setCouleurPanneau("-fx-background-color: green;");
                setClr("-fx-text-fill: green;");

            }

        });


        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createBindings(){
        BooleanProperty pasEncoreDeClic= new SimpleBooleanProperty(true);
        pasEncoreDeClic.bind(Bindings.equal(nbFois,0));
        texteDuHaut.textProperty().bind(when(pasEncoreDeClic).then("Cliquez sur un bouton").otherwise(Bindings.concat(message," choisi ",nbFois," fois")));
        panneau.styleProperty().bind(couleurPanneau);
        texteDuBas.textProperty().bind(when(pasEncoreDeClic).then("Pas de couleur :/").otherwise(Bindings.concat("Le ",message," est une belle couleur !")));
        texteDuBas.styleProperty().bind(clr);
        //  texteDuBas.textFillProperty().bind(Bindings.createObjectBinding(() -> Paint.valueOf(couleurPanneau.get()),couleurPanneau));
    }

    public int getNbFois() {
        return nbFois.get();
    }

    public IntegerProperty nbFoisProperty() {
        return nbFois;
    }

    public void setNbFois(int nbFois) {
        this.nbFois.set(nbFois);
    }

    public String getMessage() {
        return message.get();
    }

    public StringProperty messageProperty() {
        return message;
    }

    public String getCouleurPanneau() {
        return couleurPanneau.get();
    }

    public StringProperty couleurPanneauProperty() {
        return couleurPanneau;
    }

    public void setCouleurPanneau(String couleurPanneau) {
        this.couleurPanneau.set(couleurPanneau);
    }

    public void setMessage(String message) {
        this.message.set(message);
    }
}