package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage){

        // Création du conteneur principal
        BorderPane root = new BorderPane();


        Menu menu1 = new Menu("File");
        Menu menu2 = new Menu("Options");
        Menu menu3 = new Menu("Help");
        MenuBar menuBar = new MenuBar(menu1, menu2, menu3);
        root.setTop(menuBar) ;

        HBox hbox = new HBox();
        VBox vbox = new VBox();
        Label l1 = new Label("Boutons :");
        Button b1 = new Button("Bouton 1");
        Button b2 = new Button("Bouton 2");
        Button b3 = new Button("Bouton 3");
        vbox.getChildren().addAll( l1, b1, b2, b3 );

        vbox.setAlignment( Pos.CENTER );
        vbox.getChildren().forEach(child -> VBox.setMargin(child, new Insets(5.0d)));
        //vbox.getSpacing(10);     pareil

        Separator sep = new Separator(Orientation.VERTICAL);
        hbox.getChildren().addAll( vbox, sep);
        root.setLeft(hbox);


        GridPane gridpane = new GridPane();
        Label lb1 = new Label("Name :");
        Label lb2 = new Label("Email :");
        Label lb3 = new Label("Password :");
        TextField t1 = new TextField();
        TextField t2 = new TextField();
        TextField t3 = new TextField();
        gridpane.addRow(0,lb1, t1);
        gridpane.addRow(1,lb2, t2);
        gridpane.addRow(2,lb3, t3);
        Button b4 = new Button("Submit");
        Button b5 = new Button("Cancel");
        gridpane.addRow(3,b4, b5);
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        gridpane.setAlignment( Pos.CENTER );
        root.setCenter(gridpane);

        // Création de la ligne de séparation
        // Création du bandeau en bas de la fenêtre
        HBox bottomControls = new HBox();
        VBox btmControls = new VBox();
        Label l2 = new Label("Ceci est un label de bas de page");
        bottomControls.setAlignment( Pos.CENTER );
        Separator sep1 = new Separator(Orientation.HORIZONTAL);
        bottomControls.getChildren().addAll( l2 );
        btmControls.getChildren().addAll( sep1, bottomControls);

        root.setBottom(btmControls);


        // Ajout du conteneur à la scene
        Scene scene = new Scene(root);

        // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
        primaryStage.setScene( scene );
        primaryStage.setWidth( 600 );
        primaryStage.setHeight( 400 );
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");

        // Affichage de la fenêtre
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

