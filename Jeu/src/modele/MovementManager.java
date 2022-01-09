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
        persoJoueur=c.lireCarte("C:\\Users\\thoma\\Desktop\\2A-JFXGame\\Jeu\\rsrc\\Map\\map1.txt");
        dep = new Deplaceur();
    }

    public Carte getCarte() {return c;}

    public int gestionTouches(KeyEvent k){
        int code=dep.traitementMouvement(c,persoJoueur,k);
        if(code==2){
            List<Entity> ent = c.whatIsAt(c.getPosJoueur((PersoJoueur) persoJoueur));
            for (Entity entity : ent){
                if(entity.getClass() == Objet.class)
                    c.destroy((Objet) entity);
                return 2;
            }
        }
        return 0;
    }
}
