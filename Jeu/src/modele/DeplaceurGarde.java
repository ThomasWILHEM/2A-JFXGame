package modele;

import javafx.application.Platform;
import javafx.scene.image.Image;

import java.security.Guard;
import java.util.List;

public class DeplaceurGarde extends Deplaceur {

    public DeplaceurGarde(){
    }

    @Override
    public int deplacer(Carte c, Entity e, Position pVoulue) {
        System.out.println(((Personnage) e).getDirection());
        int distance = ((Garde)e).getDistanceVue();
        List<Entity> elements = c.getElements();
        Position p = e.getP();
        c.clearVueGarde((Garde) e);
        switch(((Personnage) e).getDirection()) {
            case 'U' :
                ((Personnage) e).setDirection('R');
                Platform.runLater(()->{
                    for(int i=1;i<=distance;i++){
                        elements.add(new VueGarde(new Image("/Images/vueGarde.png"),new Position(p.getPosX(),p.getPosY()-i), (Garde) e));
                    }
                });
                break;
            case 'R' :
                ((Personnage) e).setDirection('D');
                Platform.runLater(()-> {
                    for (int i = 1; i <= distance; i++) {
                        elements.add(new VueGarde(new Image("/Images/vueGarde.png"), new Position(p.getPosX(), p.getPosY() + i), (Garde) e));
                    }
                });
                break;
            case 'D' :
                ((Personnage) e).setDirection('L');
                Platform.runLater(()-> {
                    for (int i = 1; i <= distance; i++) {
                        elements.add(new VueGarde(new Image("/Images/vueGarde.png"), new Position(p.getPosX() - i, p.getPosY()), (Garde) e));
                    }
                });
                break;
            case 'L' :
                ((Personnage) e).setDirection('U');
                Platform.runLater(()-> {
                    for (int i = 1; i <= distance; i++) {
                        elements.add(new VueGarde(new Image("/Images/vueGarde.png"), new Position(p.getPosX() + i, p.getPosY()), (Garde) e));
                    }
                });
                break;
        }
        return 0;
    }
}