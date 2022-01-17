package modele.Colisionneurs;

import modele.Utils.Carte;
import modele.Utils.Position;

public interface Colisionneur {

    /**
     * Permet de gérer la colision avec une entitée
     * @param c Carte
     * @param p Position à laquelle regarder
     * @return True si possible, False si impossible
     */
    public boolean isOkayToMove(Carte c, Position p);
}
