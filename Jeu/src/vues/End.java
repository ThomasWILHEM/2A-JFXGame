package vues;

import modele.Joueur.ListeJoueurs;
import Launcher.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import modele.Joueur.Joueur;

public class End {

    @FXML
    public Button restartButton;

    @FXML
    public Button quitButton;

    @FXML
    public ListView listeJoueurs;

    @FXML
    public Label scoreJoueur;

    private ListeJoueurs joueurs;

    public void initialize(){
        joueurs = Main.gj.getJoueurs();
        Joueur joueurActuel= Main.gj.getJoueurActuel();
        joueurActuel.actualizeInformations();
        listeJoueurs.itemsProperty().bind(joueurs.joueursProperty());

        listeJoueurs.setCellFactory(__ ->
                new ListCell<Joueur>(){
                    @Override
                    protected void updateItem(Joueur item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!empty) {
                            textProperty().bind(item.infosJoueurProperty());
                        } else {
                            textProperty().unbind();
                            setText("");
                        }
                    }
                }
        );

        scoreJoueur.textProperty().bind(joueurActuel.getScore().CounterProperty());

    }

    public void quitAction(ActionEvent actionEvent) {
        Stage s = (Stage) quitButton.getScene().getWindow();
        // SaverJoueurs.SaveJoueurs(); Quand la peristance sera en place
        s.close();
    }

    public void restartGame(ActionEvent actionEvent) throws Exception{
        Main.gj.getJoueurActuel().getScore().setScore(0);
        Main.mg.showVue("/FXML/FenetreDeJeu.fxml");
    }
}
