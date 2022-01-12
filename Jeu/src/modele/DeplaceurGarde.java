package modele;

import java.util.List;

public class DeplaceurGarde extends Deplaceur {

    public DeplaceurGarde(){
    }

    @Override
    public int deplacer(Carte c, Entity e, Position pVoulue) {
        System.out.println(((Personnage) e).getDirection());
        switch(((Personnage) e).getDirection()) {
            case 'U' : ((Personnage) e).setDirection('R');
            case 'R' : ((Personnage) e).setDirection('D');
            case 'D' : ((Personnage) e).setDirection('L');
            case 'L' : ((Personnage) e).setDirection('U');
        }
        return 0;
    }
}