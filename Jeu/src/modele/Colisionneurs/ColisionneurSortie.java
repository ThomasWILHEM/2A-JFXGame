package modele.Colisionneurs;

import modele.Utils.Carte;
import modele.Acteurs.Entity;
import modele.Utils.Position;
import modele.Acteurs.Sortie;

import java.util.List;

public class ColisionneurSortie implements Colisionneur{
    /**
     * Permet de gérer la colision avec une sortie
     * @param c Carte
     * @param p Position à laquelle regarder
     * @return True si possible, False si impossible
     */
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
