package modele;

import javafx.application.Platform;
import javafx.scene.image.Image;

public class Garde extends Personnage{

    private int distanceVue;
    private BoucleurGarde boucleurGarde;

    public Garde(Image sprite, int dist, Position p, char direction) {
        super(sprite,p,direction);
    }
}
