package modele.Persistance;

import modele.Joueur.Joueur;
import modele.Joueur.JoueurSerializable;
import modele.Joueur.ListeJoueurs;
import modele.Utils.Score;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaverJoueurs {

    public static void SaveJoueurs(ListeJoueurs liste) throws IOException {
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\thoma\\Desktop\\2A-JFXGame\\Jeu\\rsrc\\fic"));
        for (Joueur j : liste.getSaveList()){
                stream.writeObject(new JoueurSerializable(j.getNom(),j.getScore().getScore()));
        }
        stream.close();
    }
}
