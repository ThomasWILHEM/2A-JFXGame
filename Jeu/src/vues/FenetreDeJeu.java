package vues;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import modele.*;

import java.util.List;
import java.util.Map;
import java.util.Set;


public class FenetreDeJeu {

    @FXML
    public Pane map;

    @FXML
    public GridPane Grille;

    @FXML
    public Text labelTemps;

    @FXML
    public Label labelScore;

    public BoucleurJeu b;
    public Timer g;
    public MovementManager movementManager;


    private void showMap(Carte c){
        map.setBackground(new Background(new BackgroundImage(new Image("/Images/floor_01_1.png"), BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));
        List<Entity> elems= c.getElements();
        for(Entity ent : elems){
            map.getChildren().add(ent.getSprite());
        }
    }

    public void initialize(){
        b = new BoucleurJeu();
        Thread tBoucleur = new Thread(b);
        g = new Timer(90,b);

        Score s = new Score();
        movementManager = new MovementManager();
        showMap(movementManager.getCarte());

        map.setFocusTraversable(true);
        map.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch(movementManager.gestionTouches(keyEvent)) {
                    case 2:
                        s.addScore(1);
                        break;
                    default:
                        break;
                }
                showMap(movementManager.getCarte());
            }
        });
        tBoucleur.start();
        labelTemps.textProperty().bind(g.tempsProperty().asString());
        labelScore.textProperty().bind(s.CounterProperty().asString());
    }

}
