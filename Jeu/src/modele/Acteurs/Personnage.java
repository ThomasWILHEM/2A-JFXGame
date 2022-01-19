package modele.Acteurs;

import javafx.scene.image.Image;
import modele.Utils.Position;

public class Personnage extends Entity{

    /**
     * Direction du personnage
     */
    private char direction;

    public void setDirection(char dir){
        this.direction = dir;
    }

    public Personnage(Image sprite, Position p, char dir) {
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

    /**
     * Permet de set la direction du personnage
     * @param direction Char permettant de donner la direction voulue
     */
    public void changeDirection(char direction) {
        switch(direction) {
            case 'U' : this.getSprite().setRotate(270); break;
            case 'D' : this.getSprite().setRotate(90); break;
            case 'L' : this.getSprite().setRotate(180); break;
            case 'R' : this.getSprite().setRotate(0); break;
        }
        this.direction = direction;
    }
}
