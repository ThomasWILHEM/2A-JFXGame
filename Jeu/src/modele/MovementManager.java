package modele;

import javafx.scene.input.KeyEvent;

import java.util.List;

public class MovementManager {
    private Carte c;
    private DeplaceurJoueur dep;
    public MovementManager() {
        c = new Carte();
        c.lireCarte("rsrc/Map/map1.txt");
        dep = new DeplaceurJoueur();
    }

    public Carte getCarte() {return c;}

    public int gestionTouches(KeyEvent k){
        int code=0;
        List<Entity> elements = c.getElements();
        for(Entity ent : elements){
            if (ent.getClass() == PersoJoueur.class){
                code=dep.traitementMouvement(c,ent,k);
            }
        }
        if(code==2){
            List<Entity> ent = c.getElements();
            for(Entity entity : ent){
                if(entity.getClass()== PersoJoueur.class){
                    for (Entity entity2 : ent){
                        if(entity2.getClass() == Objet.class && entity2.getP().equals(entity.getP()))
                            c.destroy((Objet) entity2);
                    }
                    return 2;
                }
            }
            }
        return 0;
    }
}
