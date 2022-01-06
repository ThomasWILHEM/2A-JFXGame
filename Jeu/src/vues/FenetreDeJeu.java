package vues;

import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import modele.Boucleur;
import modele.BoucleurJeu;
import modele.Timer;


public class FenetreDeJeu {

    @FXML
    public Canvas image;

    @FXML
    public GridPane Grille;

    @FXML
    public Text labelTemps;

    public BoucleurJeu b;
    public Timer g;



    public void initialize(){
        b = new BoucleurJeu();
        Thread tBoucleur = new Thread(b);
        g = new Timer(90,b);
        GraphicsContext gc = image.getGraphicsContext2D();
        gc.drawImage(new Image("/Images/voleurUnique.png"),0,0);
        tBoucleur.start();
        labelTemps.textProperty().bind(g.tempsProperty().asString());
    }

}
