package fr.amu.iut.exercice14;

import javafx.beans.Observable;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.*;
import javafx.collections.FXCollections;

import java.util.Objects;

@SuppressWarnings("Duplicates")
public class MainPersonnes {

    private static SimpleListProperty<Personne> lesPersonnes;
    private static IntegerProperty ageMoyen;
    private static IntegerProperty nbParisiens;

    private static IntegerBinding calculAgeMoyen;
    private static IntegerBinding calculnbParisiens;


    public static void main(String[] args) {

        lesPersonnes = new SimpleListProperty<>(FXCollections.observableArrayList(personne -> new Observable[] {personne.ageProperty()}));
        ageMoyen = new SimpleIntegerProperty();



        calculAgeMoyen = new IntegerBinding() {
            // constructeur de la classe interne anonyme
            {
                this.bind(lesPersonnes); // appel du constructeur de la classe mère (DoubleBinding)
            }

            protected int computeValue() {
                if (lesPersonnes.isEmpty()) {
                    return 0;
                }
                int total = 0;
                for (Personne pr : lesPersonnes) {
                    total += pr.getAge();

                }
                return total / lesPersonnes.size();
            }
        };

        lesPersonnes = new SimpleListProperty<>(FXCollections.observableArrayList(personne -> new Observable[] {personne.villeDeNaissanceProperty()}));

        nbParisiens = new SimpleIntegerProperty();
            calculnbParisiens = new IntegerBinding() {
                // constructeur de la classe interne anonyme
                {
                    this.bind(lesPersonnes); // appel du constructeur de la classe mère (DoubleBinding)
                }
                protected int computeValue() {
                    if (lesPersonnes.isEmpty()) {
                        return 0;
                    }
                    int total = 0;
                    for (Personne pr : lesPersonnes){
                        if(Objects.equals(pr.getVilleDeNaissance(), "Paris")){
                            total += 1;
                        }
                    }

                    return total;
                }
        };
        nbParisiens.bind(calculnbParisiens);



        question1();
        question2();
    }

    public static void question1() {
        System.out.println("1 - L'age moyen est de " + ageMoyen.getValue() + " ans");
        Personne pierre = new Personne("Pierre", 20);
        lesPersonnes.add(pierre);
        System.out.println("2 - L'age moyen est de " + ageMoyen.getValue() + " ans");
        Personne paul = new Personne("Paul", 40);
        lesPersonnes.add(paul);
        System.out.println("3 - L'age moyen est de " + ageMoyen.getValue() + " ans");
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(jacques);
        System.out.println("4 - L'age moyen est de " + ageMoyen.getValue() + " ans");
        paul.setAge(100);
        System.out.println("5 - L'age moyen est de " + ageMoyen.getValue() + " ans");
        lesPersonnes.remove(paul);
        System.out.println("6 - L'age moyen est de " + ageMoyen.getValue() + " ans");
    }

    public static void question2() {
        System.out.println("Il y a " + nbParisiens.getValue() + " parisiens");
        lesPersonnes.get(0).setVilleDeNaissance("Marseille");
        System.out.println("Il y a " + nbParisiens.getValue() + " parisiens");
        lesPersonnes.get(1).setVilleDeNaissance("Montpellier");
        System.out.println("Il y a " + nbParisiens.getValue() + " parisien");
        for (Personne p : lesPersonnes)
            p.setVilleDeNaissance("Paris");
        System.out.println("Il y a " + nbParisiens.getValue() + " parisiens");
    }

}

