package modele.Deplaceurs;

import javafx.application.Platform;
import javafx.scene.image.Image;
import modele.Acteurs.*;
import modele.Utils.Carte;
import modele.Utils.Position;

import java.util.List;

public class DeplaceurGarde extends Deplaceur {

    /**
     * Personnage joueur
     */
    private PersoJoueur j;

    public DeplaceurGarde(PersoJoueur pj){
        j = pj;
    }

    /**
     * Permet de déplacer un garde
     * @param c Carte
     * @param e Entitée à déplacer
     * @param pVoulue Position à laquelle déplacer l'entitée
     * @return Retourne un code
     */
    @Override
    public int deplacer(Carte c, Entity e, Position pVoulue) {
        int distance = ((Garde)e).getDistanceVue();
        List<Entity> elements = c.getElements();
        Position p = e.getP();
        c.clearVueGarde((Garde) e);
        Position posJ =j.getP();
        switch(((Garde) e).getDirection()) {
            case 'U' :
                ((Garde) e).changeDirection('R');
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
                ((Garde) e).changeDirection('D');
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
                ((Garde) e).changeDirection('L');
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
                ((Garde) e).changeDirection('U');
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