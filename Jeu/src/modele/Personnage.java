package modele;

import javafx.scene.image.Image;

abstract class Personnage extends Entity{

    private int speed;

    public Personnage(Image sprite, Position p)
    {
        super(sprite,p,false);
    }
}
