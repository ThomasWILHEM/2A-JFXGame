package vues;

import Launcher.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modele.Joueur.Joueur;
import modele.Utils.Score;

public class Start {
    @FXML
    public TextField name;

    @FXML
    public Button playButton;

    @FXML
    public Button quitButton;

    public void onPlay(ActionEvent actionEvent) throws Exception {
        String nomJoueur = name.getText();
        if(nomJoueur == "")
            nomJoueur="SansNom";
        Main.gj.setJoueurActuel(new Joueur(nomJoueur,new Score()));
        Main.mg.showVue("/FXML/FenetreDeJeu.fxml");
    }

    public void onQuit(ActionEvent actionEvent) {
        Stage s = (Stage) playButton.getScene().getWindow();
        s.close();
        System.exit(0);
    }
}
