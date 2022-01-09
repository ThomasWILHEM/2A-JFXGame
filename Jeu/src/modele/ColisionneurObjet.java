package modele;

import java.util.List;

public class ColisionneurObjet implements Colisionneur{

    @Override
    public boolean isOkayToMove(Carte c, Position p) {
        List<Entity> temp = c.whatIsAt(p);
        if (temp != null){
            for(Entity ent : temp){
                if(ent.getClass() == Objet.class)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
