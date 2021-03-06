package modele.Deplaceurs;

import javafx.scene.input.KeyEvent;
import modele.Utils.Carte;
import modele.Colisionneurs.ColisionneurGarde;
import modele.Colisionneurs.ColisionneurMur;
import modele.Colisionneurs.ColisionneurObjet;
import modele.Colisionneurs.ColisionneurSortie;
import modele.Acteurs.Entity;
import modele.Acteurs.Personnage;
import modele.Utils.Position;

public class DeplaceurJoueur extends Deplaceur{


    /**
     * Colisionneur mur
     */
    private ColisionneurMur cm;

    /**
     * Colisionneur garde
     */
    private ColisionneurGarde cg;

    /**
     * Colisionneur objet
     */
    private ColisionneurObjet co;

    /**
     * Colisionneur sortie
     */
    private ColisionneurSortie cs;

    public DeplaceurJoueur(){
        cm = new ColisionneurMur();
        cg = new ColisionneurGarde();
        co = new ColisionneurObjet();
        cs = new ColisionneurSortie();
    }

    /**
     * Permet de déplacer (changer de direction et déplacer) le joueur en fonction d'une touche
     * @param c Carte
     * @param e Entitée à déplacer
     * @param k KeyEvent
     * @return Retourne un code
     */
    public int traitementMouvement(Carte c, Entity e, KeyEvent k){
        Position p = e.getP();
        int code;
        switch(k.getCode()){
            case UP : ((Personnage) e).changeDirection('U');code=deplacer(c,e,new Position(p.getPosX(),p.getPosY()-1));break;
            case DOWN: ((Personnage) e).changeDirection('D');code=deplacer(c,e,new Position(p.getPosX(),p.getPosY()+1));break;
            case LEFT: ((Personnage) e).changeDirection('L');code=deplacer(c,e,new Position(p.getPosX()-1,p.getPosY()));break;
            case RIGHT: ((Personnage) e).changeDirection('R');code=deplacer(c,e,new Position(p.getPosX()+1,p.getPosY()));break;
            default: code=-1;break;
        }
        return code;
    }


    /**
     * Permet de déplacer le joueur
     * @param c Carte
     * @param e Entitée à déplacer
     * @param pVoulue Position à laquelle déplacer l'entitée
     * @return Retourne un code
     */
    @Override
    public int deplacer(Carte c, Entity e, Position pVoulue){
        Position p;
        if(cm.isOkayToMove(c,pVoulue) && cg.isOkayToMove(c,pVoulue)){
            p = e.getP();
            p.setPosX(pVoulue.getPosX());
            p.setPosY(pVoulue.getPosY());
            if(co.isOkayToMove(c,pVoulue)){
                return 2; // Joueur récupère un objet
            }
            if(!cs.isOkayToMove(c,pVoulue)){
                return 3; // Fin de niveau
            }
            return 0;
        }else if(!cg.isOkayToMove(c,pVoulue)){  // Si !mur.garde
            p = e.getP();
            p.setPosX(pVoulue.getPosX());
            p.setPosY(pVoulue.getPosY());
            System.out.println("FINFINFINFINFINFIN");
            return 4; // Car le mouvement à lieu mais le joueur à perdu
            }
        return 1;
    }
}
