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

    /**
     * Permet de charger une vue dans la HashMap
     * @param chemin Chemin de la vue
     * @return True si la vue à été créée, False si c'est la vue actuelle qui est chargée
     * @throws Exception
     */
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

    /**
     * Permet de décharger une vue
     * @param chemin Chemin de la vue à décharger
     * @throws IOException
     */
    public void unloadVue(String chemin) throws IOException {
        vues.remove(chemin);
    }
}
