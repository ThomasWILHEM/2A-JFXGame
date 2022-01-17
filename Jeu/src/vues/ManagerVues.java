package vues;

import javafx.beans.property.BooleanProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import modele.Utils.Score;

import java.io.IOException;
import java.util.HashMap;

public class ManagerVues {

    private HashMap<String,Parent> vues;
    private Stage primaryStage;
    private String currentView = "";
    private Scene sceneShowed;

    public ManagerVues(Stage primaryStage) throws Exception{
        vues = new HashMap<>();
        this.primaryStage = primaryStage;
    }

    private Boolean loadVue(String chemin) throws Exception{
        if(currentView.equals(chemin)) {
            return false;
        }
        FXMLLoader loader = new FXMLLoader();
        Parent st = loader.load(getClass().getResource(chemin));
        vues.put(chemin,st);
        return true;
    }

    public void showVue(String chemin) throws Exception{
        if (loadVue(chemin)) {
            try {
                unloadVue(currentView);
            }
            catch( Exception e)
            {

            }
            currentView = chemin;
            sceneShowed = new Scene(vues.get(chemin));
            primaryStage.setScene(sceneShowed);
            primaryStage.show();
        }
    }

    public void showGameOver(Score score){
        FXMLLoader loader = new FXMLLoader();
        try {
            BorderPane st = loader.load(getClass().getResource("/FXML/GameOver.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void unloadVue(String chemin) throws IOException {
        vues.remove(chemin);
    }
}
