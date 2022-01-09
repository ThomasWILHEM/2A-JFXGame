package modele;

abstract class Personnage extends Entity{

    private int speed;

    public Personnage(String sprite)
    {
        super(sprite,false);
    }
}
