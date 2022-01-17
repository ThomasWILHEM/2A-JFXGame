package vues;

import Launcher.Main;
import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import modele.Utils.Score;

public class End {

    @FXML
    public Label labelScore;

    @FXML
    public Button restartButton;

    @FXML
    public Button quitButton;

    public void quitAction(ActionEvent actionEvent) {
        Stage s = (Stage) quitButton.getScene().getWindow();
        s.close();
    }

    public void restartGame(ActionEvent actionEvent) throws Exception{
        Main.mg.showVue("/FXML/FenetreDeJeu.fxml");
    }

}
