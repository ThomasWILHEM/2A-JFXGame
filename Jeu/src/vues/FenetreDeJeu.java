package vues;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.awt.*;


public class FenetreDeJeu {

    @FXML
    public Canvas image;

    @FXML
    public GridPane Grille;




    public void initialize(){
        GraphicsContext gc = image.getGraphicsContext2D();
        gc.drawImage(new Image("/Images/voleurUnique.png"),0,0);
        //image.heightProperty().bind(Grille.heightProperty());
        //image.widthProperty().bind(Grille.widthProperty());
    }


}
