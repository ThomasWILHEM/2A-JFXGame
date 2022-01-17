package modele.Utils;

import Launcher.Main;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import modele.Boucleurs.BoucleurJeu;
import modele.Observateur;

public class Timer implements Observateur {

    private BoucleurJeu boucleurJeu;
    private int cptAct=0;

    private IntegerProperty tempsP =  new SimpleIntegerProperty();
    public int getTempsP() {return tempsP.getValue();}
    public void setTempsP(int value) { tempsP.setValue(value);}
    public IntegerProperty tempsProperty() { return tempsP;}

    public Timer(int t,BoucleurJeu b){
        boucleurJeu = b;
        boucleurJeu.Subscribe(this);
        setTempsP(t);
    }

    @Override
    public void update() {
        cptAct++;
        if(cptAct==60)
        {
            Platform.runLater(()->{
                if(getTempsP()!=0)
                    setTempsP(getTempsP()-1);
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
