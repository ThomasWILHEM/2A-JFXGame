package modele.Joueur;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;


public class ListeJoueurs {

    List<Joueur> saveList = new ArrayList<>();

    public List<Joueur> getSaveList() {
        return saveList;
    }

    /**
     * Liste de tous les joueurs
     */
    private ObservableList<Joueur> joueursObs = FXCollections.observableArrayList();
    private final ListProperty<Joueur> joueurs = new SimpleListProperty<>(joueursObs);
    public ObservableList<Joueur> getJoueursObs() {return joueurs.get();}
    public void setJoueursObs(ObservableList<Joueur> value) {joueurs.set(value);}
    public ListProperty<Joueur> joueursProperty() {return joueurs;}

    public void addJoueur(Joueur joueur) {
        saveList.add(joueur);
        joueursObs.add(joueur);
    }
}
