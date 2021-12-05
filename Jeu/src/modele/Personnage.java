package modele;

abstract class Personnage extends Entity{

    private float[] direction;
    private int speed;

    public Personnage(String sprite)
    {
        super(sprite);
    }
}
