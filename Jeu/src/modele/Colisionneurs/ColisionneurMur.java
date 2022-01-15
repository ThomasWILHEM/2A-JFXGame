package modele.Colisionneurs;

import modele.Utils.Carte;
import modele.Acteurs.Entity;
import modele.Utils.Position;

import java.util.List;

public class ColisionneurMur implements Colisionneur{

    @Override
    public boolean isOkayToMove(Carte c, Position p) {
        List<Entity> elements = c.getElements();
        for(Entity entity : elements){
            if(entity.getP().equals(p))
                if(entity.isSolid())
                {
                    return false;
                }
        }
        return true;
    }
}