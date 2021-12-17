package vues;

import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import modele.Boucleur;
import modele.BoucleurJeu;
import modele.gestTemps;

import java.awt.*;


public class FenetreDeJeu {

    @FXML
    public Canvas image;

    @FXML
    public GridPane Grille;

    @FXML
    public Text labelTemps;

    public Boucleur b;
    public gestTemps g;

    private IntegerProperty temps =  new SimpleIntegerProperty();
    public int getTemps() {return temps.get();}
    public void setTemps(int value) { temps.set(value);}
    public IntegerProperty tempsProperty() { return temps;}

    public void initialize(){
        g = new gestTemps();
        b = new BoucleurJeu(g);
        GraphicsContext gc = image.getGraphicsContext2D();
        gc.drawImage(new Image("/Images/voleurUnique.png"),0,0);
        //image.heightProperty().bind(Grille.heightProperty());
        //image.widthProperty().bind(Grille.widthProperty());
        labelTemps.textProperty().bind(temps.);
    }

}
