package fr.amu.iut.exercice5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

import static javafx.application.Platform.exit;


public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;

    private static ArrayList<Obstacles> obstacle;



    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        obstacle = new ArrayList<>();
        Obstacles obs1 = new Obstacles(40 , 40, 20, 20);
        obstacle.add(obs1);
        Obstacles obs2 = new Obstacles(100 , 400, 20, 20);
        obstacle.add(obs2);
        Obstacles obs3 = new Obstacles(200 , 200, 20, 20);
        obstacle.add(obs3);


        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 10);
        //panneau du jeu

        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        jeu.getChildren().addAll(obs1,obs2,obs3);
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            double x1 = j1.getLayoutX();
            double y1 = j1.getLayoutY();
            double x2 = j2.getLayoutX();
            double y2 = j2.getLayoutY();
            switch (event.getCode()) {
                case LEFT:
                    j1.deplacerAGauche();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getWidth());
                    break;
                case UP:
                    j1.deplacerEnHaut();
                    break;
                case Q:
                    j2.deplacerAGauche();
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());
                    break;
                case S:
                    j2.deplacerEnBas(scene.getWidth());
                    break;
                case Z:
                    j2.deplacerEnHaut();
                    break;

            }
            if (j1.estEnCollision(j2)){
                System.out.println("Collision....");
                exit();
        }
            for(int i=0;i < obstacle.size() ; i++){
                if(j2.estEnCollisionMur(obstacle.get(i))){
                    System.out.println("flip");
                    j2.setLayoutX(x2);
                    j2.setLayoutY(y2);

                }}
            for(int k=0;k < obstacle.size() ; k++) {
                if (j1.estEnCollisionMur(obstacle.get(k))) {
                    System.out.println("arrete");
                    j1.setLayoutX(x1);
                    j1.setLayoutY(y1);

                }
            }

            });
    }
}
