package vues;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Fenetre {

    public Button buttonTest;
    public Canvas canvasTest;

    @FXML
    private void buttonTestPressed() {
        buttonTest.setText("Vous êtes un criminel");
    }

    public void initialize(){
        GraphicsContext gc = canvasTest.getGraphicsContext2D();
        gc.drawImage(new Image("/Images/voleur.jpg"),0,0);
    }

}
