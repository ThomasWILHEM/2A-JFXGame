package modele.Joueur;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;

public class ListeJoueurs implements Serializable {

    /**
     * Liste de tous les joueurs
     */
    private ObservableList<Joueur> joueursObs = FXCollections.observableArrayList();
    private final ListProperty<Joueur> joueurs = new SimpleListProperty<>(joueursObs);
    public ObservableList<Joueur> getJoueursObs() {return joueurs.get();}
    public void setJoueursObs(ObservableList<Joueur> value) {joueurs.set(value);}
    public ListProperty<Joueur> joueursProperty() {return joueurs;}

    public void addJoueur(Joueur joueur) {
        joueursObs.add(joueur);
    }
}
