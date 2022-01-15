package modele.Deplaceurs;

import modele.Utils.Carte;
import modele.Acteurs.Entity;
import modele.Utils.Position;

public abstract class Deplaceur {
    public abstract int deplacer(Carte c, Entity e, Position pVoulue);

}
