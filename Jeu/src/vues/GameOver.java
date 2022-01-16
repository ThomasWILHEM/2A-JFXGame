package vues;

import Launcher.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GameOver {

    @FXML
    public Button restartB;

    @FXML
    public Button quitB;


    public void quitAction(ActionEvent actionEvent) {
        Stage s = (Stage) quitB.getScene().getWindow();
        s.close();
    }

    public void restartGame(ActionEvent actionEvent) throws Exception{
        Main.mg.showVue("/FXML/FenetreDeJeu.fxml");
    }

}


