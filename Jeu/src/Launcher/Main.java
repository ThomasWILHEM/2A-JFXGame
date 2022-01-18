package Launcher;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import modele.Joueur.ListeJoueurs;
import modele.Persistance.LoaderJoueurs;
import modele.Persistance.SaverJoueurs;
import modele.Utils.GestionnaireJoueurs;
import vues.ManagerVues;

public class Main extends Application {
    public static ManagerVues mg;
    public static GestionnaireJoueurs gj;
    @Override
    public void start(Stage primaryStage) throws Exception {

        gj = new GestionnaireJoueurs();
        mg = new ManagerVues(primaryStage);

        mg.showVue("/FXML/Start.fxml");

        primaryStage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }
}

