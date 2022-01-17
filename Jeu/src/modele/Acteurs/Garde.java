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
}
