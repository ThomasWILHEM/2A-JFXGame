package modele.Colisionneurs;

import modele.Utils.Carte;
import modele.Acteurs.Entity;
import modele.Acteurs.Objet;
import modele.Utils.Position;

import java.util.List;

public class ColisionneurObjet implements Colisionneur{

    /**
     * Permet de gérer la colision avec un objet
     * @param c Carte
     * @param p Position à laquelle regarder
     * @return True si possible, False si impossible
     */
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
