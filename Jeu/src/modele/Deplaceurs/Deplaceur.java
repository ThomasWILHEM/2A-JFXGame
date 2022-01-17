package modele.Deplaceurs;

import modele.Utils.Carte;
import modele.Acteurs.Entity;
import modele.Utils.Position;

public abstract class Deplaceur {
    /**
     * Permet de déplacer une entitée
     * @param c Carte
     * @param e Entitée à déplacer
     * @param pVoulue Position à laquelle déplacer l'entitée
     * @return Retourne un code
     */
    public abstract int deplacer(Carte c, Entity e, Position pVoulue);

}
