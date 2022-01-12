package modele;

import com.sun.javafx.font.CompositeStrike;
import javafx.geometry.Pos;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Deplaceur {


    private ColisionneurMur cm;
    private ColisionneurGarde cg;
    private ColisionneurObjet co;
    public Deplaceur(){
        cm = new ColisionneurMur();
        cg = new ColisionneurGarde();
        co = new ColisionneurObjet();
    }

    public int traitementMouvement(Carte c, Entity e,KeyEvent k){
        Position p = e.getP();
        int code;
        switch(k.getCode()){
            case UP : ((Personnage) e).setDirection('U');code=deplacer(c,e,new Position(p.getPosX(),p.getPosY()-1));break;
            case DOWN: ((Personnage) e).setDirection('D');code=deplacer(c,e,new Position(p.getPosX(),p.getPosY()+1));break;
            case LEFT: ((Personnage) e).setDirection('L');code=deplacer(c,e,new Position(p.getPosX()-1,p.getPosY()));break;
            case RIGHT: ((Personnage) e).setDirection('R');code=deplacer(c,e,new Position(p.getPosX()+1,p.getPosY()));break;
            default: code=-1;break;
        }
        return code;
    }

    public int deplacer(Carte c, Entity e, Position pVoulue){
        Position p;
        if(cm.isOkayToMove(c,pVoulue) && cg.isOkayToMove(c,pVoulue)){
            p = e.getP();
            p.setPosX(pVoulue.getPosX());
            p.setPosY(pVoulue.getPosY());
            if(co.isOkayToMove(c,pVoulue)){
                return 2;
            }
            return 0;
        }else if(!cg.isOkayToMove(c,pVoulue)){  // Si !mur.garde
            p = e.getP();
            p.setPosX(pVoulue.getPosX());
            p.setPosY(pVoulue.getPosY());
            return 1; // Car le moyvement à lieu mais le joueur à perdu
            }
        return 1;
    }
}
