package modele.Colisionneurs;

import modele.Utils.Carte;
import modele.Utils.Position;

public interface Colisionneur {
    public boolean isOkayToMove(Carte c, Position p);
}
