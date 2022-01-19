package modele.Persistance;

import modele.Joueur.Joueur;
import modele.Joueur.JoueurSerializable;
import modele.Joueur.ListeJoueurs;
import modele.Utils.Score;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoaderJoueurs {
    public static ListeJoueurs LoadJoueurs() throws IOException, ClassNotFoundException {
        ListeJoueurs li = new ListeJoueurs();
        FileInputStream fi = new FileInputStream("rsrc/scores");
        try {
            ObjectInputStream flot = new ObjectInputStream(fi);
            boolean cont = true;
            while (cont) {
                try {
                    JoueurSerializable js = (JoueurSerializable) flot.readObject();
                    if (js != null)
                        li.addJoueur(new Joueur(js.getNom(), new Score(js.getScoreEntier())));
                    else
                        cont = false;
                } catch (Exception e) {
                    cont = false;
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return li;
    }
}
