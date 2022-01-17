package modele.Deplaceurs;

import javafx.application.Platform;
import javafx.scene.image.Image;
import modele.Acteurs.*;
import modele.Utils.Carte;
import modele.Utils.Position;

import java.util.List;

public class DeplaceurGarde extends Deplaceur {

    private PersoJoueur j;
    public DeplaceurGarde(PersoJoueur pj){
        j = pj;
    }

    @Override
    public int deplacer(Carte c, Entity e, Position pVoulue) {
        System.out.println(((Personnage) e).getDirection());
        int distance = ((Garde)e).getDistanceVue();
        List<Entity> elements = c.getElements();
        Position p = e.getP();
        c.clearVueGarde((Garde) e);
        Position posJ =j.getP();
        switch(((Personnage) e).getDirection()) {
            case 'U' :
                ((Personnage) e).setDirection('R');
                for(int i=1;i<=distance;i++) {
                    int finalI = i;
                    Platform.runLater(() -> {
                        elements.add(new VueGarde(new Image("/Images/vueGarde.png"), new Position(p.getPosX(), p.getPosY() - finalI), (Garde) e));
                    });
                    if (posJ.equals(new Position(p.getPosX(), p.getPosY() - i))) {
                        return 1;
                    }
                }
                break;
            case 'R' :
                ((Personnage) e).setDirection('D');
                for(int i=1;i<=distance;i++) {
                    int finalI = i;
                    Platform.runLater(() -> {
                        elements.add(new VueGarde(new Image("/Images/vueGarde.png"), new Position(p.getPosX(), p.getPosY() + finalI), (Garde) e));
                    });
                    if (posJ.equals(new Position(p.getPosX(), p.getPosY() + i))) {
                        return 1;
                    }
                }
                break;
            case 'D' :
                ((Personnage) e).setDirection('L');
                for(int i=1;i<=distance;i++) {
                    int finalI = i;
                    Platform.runLater(() -> {
                        elements.add(new VueGarde(new Image("/Images/vueGarde.png"), new Position(p.getPosX()-finalI, p.getPosY()), (Garde) e));
                    });
                    if (posJ.equals(new Position(p.getPosX()-i, p.getPosY()))) {
                        return 1;
                    }
                }
                break;
            case 'L' :
                ((Personnage) e).setDirection('U');
                for(int i=1;i<=distance;i++) {
                    int finalI = i;
                    Platform.runLater(() -> {
                        elements.add(new VueGarde(new Image("/Images/vueGarde.png"), new Position(p.getPosX()+finalI, p.getPosY()), (Garde) e));
                    });
                    if (posJ.equals(new Position(p.getPosX()+i, p.getPosY()))) {
                        return 1;
                    }
                }
                break;
        }
        return 0;
    }
}