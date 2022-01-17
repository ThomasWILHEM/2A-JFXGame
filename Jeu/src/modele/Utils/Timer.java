package modele.Utils;

import Launcher.Main;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import modele.Boucleurs.BoucleurJeu;
import modele.Observateur;

public class Timer implements Observateur {

    private BoucleurJeu boucleurJeu;

    private int cptAct=0;

    public void setTemps(int temps) {
        this.temps = temps;
    }

    /**
     * Temps (en int)
     */
    private int temps;

    /**
     * Temps (en StrinProperty) pour pouvoir afficher correctement
     */
    private StringProperty tempsP =  new SimpleStringProperty();
    public String getTempsP() {return tempsP.getValue();}
    public void setTempsP(String value) { tempsP.setValue(value);}
    public StringProperty tempsProperty() { return tempsP;}

    public Timer(int t,BoucleurJeu b){
        boucleurJeu = b;
        boucleurJeu.Subscribe(this);
        temps=t;
        setTempsP("Temps restant : " + temps);
    }

    /**
     * Permet d'actualiser le String du temps pour la vue
     */
    public void actualizeTimer(){
        setTempsP("Temps restant : " + temps);
    }

    @Override
    public void update() {
        cptAct++;
        if(cptAct==60)
        {
            Platform.runLater(()->{
                if(temps!=0) {
                    setTemps(temps - 1);
                    actualizeTimer();
                }
                else {
                    try {
                        boucleurJeu.setGameOver(true);
                        Main.mg.showVue("/FXML/GameOver.fxml");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            cptAct=0;
        }
    }
}
