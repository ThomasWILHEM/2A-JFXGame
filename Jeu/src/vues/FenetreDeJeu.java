package vues;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;


public class FenetreDeJeu {

    @FXML
    public Canvas image;

    public void initialize(){
        GraphicsContext gc = image.getGraphicsContext2D();
        gc.drawImage(new Image("/Images/voleur.jpg"),0,0);
    }

}
