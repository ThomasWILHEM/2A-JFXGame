package modele.Colisionneurs;

import modele.Acteurs.Entity;
import modele.Acteurs.VueGarde;
import modele.Utils.Carte;
import modele.Utils.Position;

import java.util.List;

public class ColisionneurGarde implements Colisionneur{

    /**
     * Permet de gérer la colision avec une vue de garde
     * @param c Carte
     * @param p Position à laquelle regarder
     * @return True si possible, False si impossible
     */
    @Override
    public boolean isOkayToMove(Carte c, Position p) {
        List<Entity> elements = c.getElements();
        for(Entity entity : elements){
            if(entity.getP().equals(p))
                if(entity.getClass() == VueGarde.class) {
                    return false;
                }
        }
        return true;
    }
}
