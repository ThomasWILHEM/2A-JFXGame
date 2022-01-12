package modele;

import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

abstract class Personnage extends Entity{

    private int speed;
    private char direction;
    public Personnage(Image sprite, Position p,char dir) {
        super(sprite,p,false);
        if (dir == 'U' || dir == 'D' || dir == 'L' || dir == 'R')
        {
            direction=dir;
        }
        else
            direction='U';
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        switch(direction) {
            case 'U' : this.getSprite().setRotate(270); break;
            case 'D' : this.getSprite().setRotate(90); break;
            case 'L' : this.getSprite().setRotate(180); break;
            case 'R' : this.getSprite().setRotate(0); break;
        }
        this.direction = direction;
    }
}
