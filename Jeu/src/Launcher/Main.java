package Launcher;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import modele.Joueur.GestionnaireJoueurs;
import vues.ManagerVues;

public class Main extends Application {
    public static ManagerVues mg;
    public static GestionnaireJoueurs gj;
    @Override
    public void start(Stage primaryStage) throws Exception {

        gj = new GestionnaireJoueurs();
        mg = new ManagerVues(primaryStage);
        primaryStage.setResizable(false);
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

