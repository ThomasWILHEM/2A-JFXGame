package Launcher;

import javafx.application.Application;
import javafx.stage.Stage;
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

    }
}

