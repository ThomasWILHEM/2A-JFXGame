package modele;

import javafx.application.Platform;
import javafx.scene.image.Image;

public class Garde extends Personnage implements Observateur{

    private int distanceVue;
    private int dir; //1=UP 2=RIGHT 3=DOWN 4=LEFT
    private BoucleurGarde boucleurGarde;

    public Garde(Image sprite, int dist, Position p) {
        super(sprite,p);
    }

    @Override
    public void update(){
        Platform.runLater(()->{
            if(dir==4)
                dir=1;
            dir++;
        });
    }
}
