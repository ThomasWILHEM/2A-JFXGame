package modele;

import com.sun.javafx.event.EventUtil;
import javafx.scene.input.KeyEvent;

import java.util.List;

public class MovementManager {
    private Carte c;
    private Deplaceur dep;
    private Entity persoJoueur;
    public MovementManager() {
        c = new Carte();
        c.lireCarte("C:\\Users\\thoma\\Desktop\\tesst\\2A-JFXGame\\Jeu\\rsrc\\Map\\map1.txt");
        dep = new Deplaceur();
    }

    public Carte getCarte() {return c;}

    public int gestionTouches(KeyEvent k){
        PersoJoueur pj=new PersoJoueur(null,null);
        int code=dep.traitementMouvement(c,persoJoueur,k);
        if(code==2){
            List<Entity> ent = c.getElements();
            for(Entity entity : ent){
                if(entity.getClass()== PersoJoueur.class){
                    pj= (PersoJoueur) entity;
                }
            }
            for (Entity entity : ent){
                if(entity.getClass() == Objet.class)
                    if(entity.getP().equals(pj.getP()))
                        c.destroy((Objet) entity);
                }
                return 2;
            }
        return 0;
    }
}
