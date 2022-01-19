package modele;

import javafx.scene.input.KeyEvent;
import modele.Acteurs.Entity;
import modele.Acteurs.Garde;
import modele.Acteurs.Objet;
import modele.Acteurs.PersoJoueur;
import modele.Deplaceurs.DeplaceurJoueur;
import modele.Utils.Carte;

import java.util.List;

public class ModeleManager {
    private Carte c;
    private DeplaceurJoueur dep;
    private int numNiveau;

    public int getNumNiveau() {
        return numNiveau;
    }

    public ModeleManager() {
        c = new Carte();
        c.lireCarte("rsrc/Map/map1.txt");
        dep = new DeplaceurJoueur();
        numNiveau=1;
    }

    /**
     * Permet de récuperer la carte
     * @return Carte
     */
    public Carte getCarte() {return c;}

    public int gestionTouches(KeyEvent k) {
        int code=0;
        List<Entity> elements = c.getElements();
        for(Entity ent : elements){
            if (ent.getClass() == PersoJoueur.class){
                code=dep.traitementMouvement(c,ent,k);
            }
        }
        switch(code){
            case 2:
                List<Entity> ent = c.getElements();
                for (Entity entity : ent) {
                    if (entity.getClass() == PersoJoueur.class) {
                        for (Entity entity2 : ent) {
                            if (entity2.getClass() == Objet.class && entity2.getP().equals(entity.getP()))
                                c.destroy((Objet) entity2);
                        }
                        return 2;
                    }
                }
            case 3:
                if(numNiveau==3){
                    return 120;
                }
                numNiveau++;
                return 3;

            default: return code;
        }
    }
}
