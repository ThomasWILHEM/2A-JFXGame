package modele;

public class ColisionneurGarde implements Colisionneur{

    @Override
    public boolean isOkayToMove(Carte c, Position p) {return true;}
}
