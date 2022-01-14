package modele;

import java.util.List;

public class DeplaceurGarde extends Deplaceur {

    public DeplaceurGarde(){
    }

    @Override
    public int deplacer(Carte c, Entity e, Position pVoulue) {
        System.out.println(((Personnage) e).getDirection());
        switch(((Personnage) e).getDirection()) {
            case 'U' : ((Personnage) e).setDirection('R');break;
            case 'R' : ((Personnage) e).setDirection('D');break;
            case 'D' : ((Personnage) e).setDirection('L');break;
            case 'L' : ((Personnage) e).setDirection('U');break;
        }
        return 0;
    }
}