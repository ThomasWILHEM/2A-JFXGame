package modele.Joueur;

import java.io.Serializable;

public class JoueurSerializable implements Serializable {

    private String nom;
    private int scoreEntier;

    public JoueurSerializable(String nom, int score) {
        this.nom = nom;
        this.scoreEntier = score;
    }

    public int getScoreEntier() {
        return scoreEntier;
    }

    public void setScoreEntier(int scoreEntier) {
        this.scoreEntier = scoreEntier;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }




}
