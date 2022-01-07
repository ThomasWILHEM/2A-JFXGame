package modele;

import com.sun.javafx.font.CompositeStrike;
import javafx.geometry.Pos;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Map;
import java.util.Set;

public class Deplaceur {


    private ColisionneurMur cm;
    private ColisionneurGarde cg;
    public Deplaceur(){
        cm = new ColisionneurMur();
        cg = new ColisionneurGarde();
    }

    private Position findInMap(Carte c,Entity e){
        if(c.getElements().containsKey(e)){
            Set<Map.Entry<Entity,Position>> recherche = c.getElements().entrySet();
            for(Map.Entry<Entity,Position> ent:recherche){
                if(ent.getKey() == e)
                {
                    return ent.getValue();
                }
            }
        }
        return null;
    }

    public void traitementMouvement(Carte c, Entity e,KeyEvent k){
        Position p = findInMap(c,e);
        switch(k.getCode()){
            case UP : p.setPosY(p.getPosY()-1);deplacer(c,e,p);break;
            case DOWN: p.setPosY(p.getPosY()+1);deplacer(c,e,p);break;
            case LEFT: p.setPosX(p.getPosX()-1);deplacer(c,e,p);break;
            case RIGHT: p.setPosX(p.getPosX()+1);deplacer(c,e,p);break;
            default: break;
        }
    }

    public boolean deplacer(Carte c, Entity e, Position pVoulue){
        Position p;
        if(cm.isOkayToMove(c,pVoulue) && cg.isOkayToMove(c,pVoulue)){
                        p = findInMap(c,e);
                        p.setPosX(pVoulue.getPosX());
                        p.setPosY(pVoulue.getPosY());
                        return true;
        }else if(!cg.isOkayToMove(c,pVoulue)){  // Si !mur.garde
            p = findInMap(c,e);
            p.setPosX(pVoulue.getPosX());
            p.setPosY(pVoulue.getPosY());
            return false; // Car le moyvement à lieu mais le joueur à perdu
            }
        return false;
    }
}
