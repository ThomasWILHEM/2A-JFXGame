package vues;

import Launcher.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GameOver {

    @FXML
    public Button restartB;

    @FXML
    public Button quitB;

    /**
     * Méthode appelée lorsque le joueur clique sur le boutton pour quitter
     * @param actionEvent
     */
    public void quitAction(ActionEvent actionEvent) {
        Stage s = (Stage) quitB.getScene().getWindow();
        s.close();
        System.exit(0);
    }

    /**
     * Méthode appelée lorsque le joueur clique sur le bouton pour relancer une partie
     * @param actionEvent
     * @throws Exception
     */
    public void restartGame(ActionEvent actionEvent) throws Exception{
        Main.gj.getJoueurActuel().getScore().setScore(0);
        Main.mg.showVue("/FXML/FenetreDeJeu.fxml");
    }

}


