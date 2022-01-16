package Launcher;

import javafx.application.Application;
import javafx.stage.Stage;
import vues.ManagerVues;

public class Main extends Application {
    public static ManagerVues mg;
    @Override
    public void start(Stage primaryStage) throws Exception {

        mg = new ManagerVues(primaryStage);
        mg.loadVue("/FXML/End.fxml");
        mg.showVue("/FXML/End.fxml");

    }
}
