package modele.Persistance;

import modele.Joueur.Joueur;
import modele.Joueur.JoueurSerializable;
import modele.Joueur.ListeJoueurs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaverJoueurs {

    public static void SaveJoueurs(ListeJoueurs liste) throws IOException {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("rsrc/scores"));
        for (Joueur j : liste.getSaveList()){
                stream.writeObject(new JoueurSerializable(j.getNom(),j.getScore().getScore()));
        }
        stream.close();
    }
}
