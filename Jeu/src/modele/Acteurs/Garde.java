package modele.Acteurs;

import javafx.scene.image.Image;
import modele.Utils.Position;

public class Garde extends Personnage{

    /**
     * Distance de vue d'un garde
     */
    private int distanceVue;

    /**
     *
     */
    private static int cptGarde=0;

    /**
     * Id du garde
     */
    private int id;

    public Garde(Image sprite, int dist, Position p, char direction) {
        super(sprite,p,direction);
        distanceVue=dist;
        id=cptGarde;
        cptGarde++;
        super.isSolid = true;
    }

    public int getId() {
        return id;
    }

    public int getDistanceVue() {
        return distanceVue;
    }

    @Override
    public boolean equals(Object o){
        return ((Garde)o).getId()==this.id;
    }

    @Override
    public void changeDirection(char direction) {
        switch(direction) {
            case 'U' : this.getSprite().setRotate(0); break;
            case 'D' : this.getSprite().setRotate(90); break;
            case 'L' : this.getSprite().setRotate(180); break;
            case 'R' : this.getSprite().setRotate(270); break;
        }
        setDirection(direction);
    }

}
