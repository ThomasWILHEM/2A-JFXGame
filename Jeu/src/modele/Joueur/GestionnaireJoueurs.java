package modele.Joueur;

import modele.Joueur.Joueur;
import modele.Joueur.ListeJoueurs;
import modele.Persistance.LoaderJoueurs;

import java.io.IOException;

public class GestionnaireJoueurs {

    /**
     * Liste des joueurs
     */
    private ListeJoueurs joueurs;

    /**
     * Joueur actuellement entrain de jouer
     */
    private Joueur joueurActuel;

    public GestionnaireJoueurs() {
        try {
            joueurs= LoaderJoueurs.LoadJoueurs();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(joueurs == null)
            joueurs = new ListeJoueurs();
    }

    /**
     * Permet de set le joueur actuel et de l'ajouter dans la liste de joueurs
     * @param joueurActuel
     */
    public void setJoueurActuel(Joueur joueurActuel) {
        this.joueurActuel = joueurActuel;
        joueurs.addJoueur(joueurActuel);
    }

    public ListeJoueurs getJoueurs() {
        return joueurs;
    }

    public Joueur getJoueurActuel() {
        return joueurActuel;
    }
}
