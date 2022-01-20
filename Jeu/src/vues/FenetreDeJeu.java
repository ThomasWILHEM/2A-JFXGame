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

import java.util.ArrayList;
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
    public ModeleManager modeleManager;

    private List<IAGarde> IAGenerees;

    /**
     * Permet d'actuliser la vue en ré-affichant la carte
     * @param c Carte
     */
    private void showMap(Carte c){
        map.getChildren().clear();
        map.setBackground(new Background(new BackgroundImage(new Image("/Images/floor_01_1.png"), BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));
        List<Entity> elems= c.getElements();
        for(Entity ent : elems){
            map.getChildren().add(ent.getSprite());
        }
    }

    private void setScreenSize(){
        Main.mg.setWindowWidth(modeleManager.getCarte().getLongueurP()*45);
        Main.mg.setWindowHeight((modeleManager.getCarte().getLargeurP()*45 + 200));
    }

    private void addIA(List<IAGarde> liste){
        for(Entity ent : modeleManager.getCarte().getElements()){
            if(ent.getClass() == Garde.class)
                liste.add(new IAGarde(modeleManager.getCarte(),b,(Garde)ent));
        }
    }
    public void initialize(){
        IAGenerees = new ArrayList<>();
        b = new BoucleurJeu();
        Thread tBoucleur = new Thread(b);
        g = new Timer(50,b);

        Score s = Main.gj.getJoueurActuel().getScore();
        s.refreshScore();
        modeleManager = new ModeleManager();
        ObservableList<Entity> entities = modeleManager.getCarte().getElements();
        entities.addListener((InvalidationListener) observable -> {
            // Vérifie que le joueur n'est pas touché par une zone
            showMap(modeleManager.getCarte());
        });

        addIA(IAGenerees);

        map.setFocusTraversable(true);
        setScreenSize();
        map.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch(modeleManager.gestionTouches(keyEvent)) {
                    case 2:
                        s.addScore(1);
                        s.refreshScore();
                        break;
                    case 3:
                        map.getChildren().clear();
                        for (IAGarde ia:IAGenerees)
                            ia.setActive(false);
                        IAGenerees.clear();
                        modeleManager.getCarte().loadNewLevel(modeleManager.getNumNiveau());
                        setScreenSize();
                        addIA(IAGenerees);
                        break;
                    case 4:
                        try {
                            b.setGameOver(true);
                            Main.mg.showVue("/FXML/GameOver.fxml");

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 120: //Fin du jeu
                        try {
                            b.setGameOver(true);
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
        showMap(modeleManager.getCarte());
        labelTemps.textProperty().bind(g.tempsProperty());
        labelScore.textProperty().bind(s.CounterProperty());
    }

}
