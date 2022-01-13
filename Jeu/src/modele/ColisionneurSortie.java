package modele;

import java.util.List;

public class ColisionneurSortie implements Colisionneur{
    @Override
    public boolean isOkayToMove(Carte c, Position p) {
        List<Entity> elements = c.getElements();
        for(Entity entity : elements){
            if(entity.getP().equals(p))
                if(entity.getClass() == Sortie.class) {
                    return false;
                }
        }
        return true;
    }
}
