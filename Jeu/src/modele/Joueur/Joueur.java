package modele.Joueur;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import modele.Utils.Score;

import java.io.Serializable;

public class Joueur implements Serializable {

    /**
     * Permet d'obtenir les informations du joueur en un String
     */
    private final StringProperty infosJoueur = new SimpleStringProperty();
    public String getinfosJoueur() {return infosJoueur.get();}
    public StringProperty infosJoueurProperty() {return infosJoueur;}
    public void setinfosJoueur(String infosJoueur) {this.infosJoueur.set(infosJoueur);}



    /**
     * Nom du joueur
     */
    private String nom;
    /**
     * Score du joueur
     */
    private Score s;

    public Score getScore() {
        return s;
    }

    public String getNom() {
        return nom;
    }

    public Joueur(String nom, Score s) {
        this.nom=nom;
        this.s = s;
        setinfosJoueur(nom + " --> " + s.getCounterP());
    }

    /**
     * Permet d'actualiser le String pour la vue
     */
    public void refreshInformations(){
        setinfosJoueur(nom + " --> " + s.getCounterP());
    }
}
