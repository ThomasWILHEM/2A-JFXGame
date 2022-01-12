package modele;

import java.util.ArrayList;
import java.util.List;

public class ColisionneurObjet implements Colisionneur{

    @Override
    public boolean isOkayToMove(Carte c, Position p) {
        List<Entity> elements = c.getElements();
        for(Entity entity : elements){
            if(entity.getP().equals(p))
                if(entity.getClass() == Objet.class)
                {
                    return true;
                }
        }
        return false;
    }
}
