package modele;

public class ColisionneurMur implements Colisionneur{

    @Override
    public boolean isOkayToMove(Carte c, Position p) {
        if (c.whatIsAt(p) != null){
            if(!(((Entity)(c.whatIsAt(p))).isSolid()))
            {
                return true;
            }else{
                return false;
            }
        }
        return true;
    }
}
