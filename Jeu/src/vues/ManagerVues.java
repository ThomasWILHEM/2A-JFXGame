package vues;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class ManagerVues {

    private HashMap<String,Parent> vues;
    private Stage primaryStage;
    private Scene sceneShowed;
    public ManagerVues(Stage primaryStage) throws Exception{
        vues = new HashMap<>();
        this.primaryStage = primaryStage;
    }

    public void loadVue(String chemin) throws Exception{
        Parent st = FXMLLoader.load(getClass().getResource(chemin));
        vues.put(chemin,st);
    }

    public void showVue(String chemin) throws Exception{
        loadVue(chemin);
        sceneShowed = new Scene(vues.get(chemin));
        primaryStage.setScene(sceneShowed);
        primaryStage.show();
    }

    public void unloadVue(String chemin) throws IOException {
        vues.replace(chemin,FXMLLoader.load(getClass().getResource(chemin)));
    }
}
