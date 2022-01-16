package vues;

import Launcher.Main;
import javafx.beans.InvalidationListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import modele.*;
import modele.Acteurs.Entity;
import modele.Acteurs.Garde;
import modele.Boucleurs.BoucleurJeu;
import modele.Utils.Carte;
import modele.Utils.IAGarde;
import modele.Utils.Score;
import modele.Utils.Timer;

import java.util.List;


public class FenetreDeJeu{

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
        map.getChildren().clear();
        map.setBackground(new Background(new BackgroundImage(new Image("/Images/floor_01_1.png"), BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));
        List<Entity> elems= c.getElements();
        for(Entity ent : elems){
            map.getChildren().add(ent.getSprite());
        }
    }

    public void initialize(){
        b = new BoucleurJeu();
        Thread tBoucleur = new Thread(b);
        g = new Timer(2,b);

        Score s = new Score();
        movementManager = new MovementManager();
        ObservableList<Entity> entities = movementManager.getCarte().getElements();
        entities.addListener((InvalidationListener) observable -> {
            // Vérif que le joueur n'est pas touché par une zone
            showMap(movementManager.getCarte());
        });
        for(Entity ent : entities){
            if(ent.getClass() == Garde.class)
                new IAGarde(movementManager.getCarte(),b,(Garde)ent);
        }
        map.setFocusTraversable(true);
        map.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch(movementManager.gestionTouches(keyEvent)) {
                    case 4:
                        try {
                            Main.mg.showVue("/FXML/End.fxml");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        s.addScore(1);
                        break;
                    case 120: //Fin du jeu
                        try {
                            Main.mg.showVue("/FXML/End.fxml");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    default:
                        break;
                }
            }
        });
        tBoucleur.start();
        showMap(movementManager.getCarte());
        labelTemps.textProperty().bind(g.tempsProperty().asString());
        labelScore.textProperty().bind(s.CounterProperty().asString());
    }

}
