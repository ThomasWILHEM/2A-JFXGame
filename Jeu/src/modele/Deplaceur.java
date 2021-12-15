package modele;

import java.util.Map;
import java.util.Set;

public class Deplaceur {

    private ColisionneurMur cm;
    private ColisionneurGarde cg;

    public boolean deplacer(Carte c, Entity e, Position pVoulue){
        if(cm.isOkayToMove(c,pVoulue) && cg.isOkayToMove(c,pVoulue)){
            if(c.getElements().containsKey(e)){
                Set<Map.Entry<Entity,Position>> recherche = c.getElements().entrySet();
                for(Map.Entry<Entity,Position> ent:recherche){
                    if(ent.getKey() == e)
                    {
                        ent.getValue().setPosX(pVoulue.getPosX());
                        ent.getValue().setPosY(pVoulue.getPosY());
                        return true;
                    }
                }
            }
        }else if(!cg.isOkayToMove(c,pVoulue)){  // Pas super, redondance de code, à modifier
            if(c.getElements().containsKey(e)){
                Set<Map.Entry<Entity,Position>> recherche = c.getElements().entrySet();
                for(Map.Entry<Entity,Position> ent:recherche){
                    if(ent.getKey() == e)
                    {
                        ent.getValue().setPosX(pVoulue.getPosX());
                        ent.getValue().setPosY(pVoulue.getPosY());
                        return false; // Car le moyvement à lieu mais le joueur à perdu
                    }
                }
            }
        }
        return false;
    }

}
