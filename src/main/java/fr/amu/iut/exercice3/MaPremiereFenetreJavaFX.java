package fr.amu.iut.exercice3;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class MaPremiereFenetreJavaFX extends Application {


    // Label affichant le message de bienvenue
    private Label helloLabel;

    // Champ de saisi du nom de l'utilisateur
    private TextField nameField;

    // Bouton déclenchant la mise à jour du texte
    private Button button;

    // Gestionnaire d'évènements appelé lors du clic sur le bouton
    EventHandler<MouseEvent> buttonClickHandler = actionEvent -> {
        helloLabel.setText( "Bonjour à toi, "+nameField.getText() );
    };
    public static void main(String[] args) {
        launch(args);
    }

    private void handleButonClick(Event event) {
        helloLabel.setText( "Bonjour à toi, "+nameField.getText() );
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vbox = new VBox();
        vbox.setAlignment( Pos.CENTER );

        // Création et ajout du label au conteneur
        this.helloLabel = new Label("Bonjour à tous !");
        vbox.getChildren().add( helloLabel );

        this.nameField = new TextField("Veuillez saisir un nom");
        nameField.setMaxWidth(180.0d);
        nameField.setFont( Font.font("Courier", FontWeight.NORMAL, 12) );
        vbox.getChildren().add( nameField );

        // Ajout d'un bouton avec du texte
        this.button = new Button("Dire bonjour");
        vbox.getChildren().add( button );

        button.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> handleButonClick(actionEvent) );        Scene scene = new Scene( vbox );

        // Ajout de la scene à la fenêtre
        primaryStage.setScene( scene );


        primaryStage.setTitle("La page d'un Pro de JavaFX");
        primaryStage.show();
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);


    }
}
