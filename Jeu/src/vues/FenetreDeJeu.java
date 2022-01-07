package vues;

import javafx.beans.property.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import modele.*;

import java.util.Map;
import java.util.Set;


public class FenetreDeJeu {

    @FXML
    public Pane map;

    @FXML
    public GridPane Grille;

    @FXML
    public Text labelTemps;

    public BoucleurJeu b;
    public Timer g;
    public MovementManager movementManager;


    private void showMap(Carte c){
        map.setBackground(new Background(new BackgroundImage(new Image("/Images/floor_01_1.png"), BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));
        Set<Map.Entry<modele.Entity,Position>> elems = c.getElements().entrySet();
        for(Map.Entry<Entity,Position> ent : elems){
            ImageView i = new ImageView(ent.getKey().getSprite());
            i.xProperty().bind(ent.getValue().posXProperty().multiply(45));
            i.yProperty().bind(ent.getValue().posYProperty().multiply(45));
            map.getChildren().add(i);
        }
    }

    public void initialize(){
        b = new BoucleurJeu();
        Thread tBoucleur = new Thread(b);
        g = new Timer(90,b);
        movementManager = new MovementManager();
        showMap(movementManager.getCarte());

        map.setFocusTraversable(true);
        map.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                movementManager.gestionTouches(keyEvent);
                showMap(movementManager.getCarte());
            }
        });
        tBoucleur.start();
        labelTemps.textProperty().bind(g.tempsProperty().asString());
    }

}
