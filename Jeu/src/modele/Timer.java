package modele;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Timer implements Observateur {

    private BoucleurJeu boucleurJeu;
    private int temps;
    private int cptAct=0;

    private IntegerProperty tempsP =  new SimpleIntegerProperty();
    public int getTempsP() {return getTemps();}
    public void setTempsP(int value) { setTemps(value);}
    public IntegerProperty tempsProperty() { return tempsP;}

    public Timer(int t,BoucleurJeu b){
        boucleurJeu = b;
        boucleurJeu.Subscribe(this);
        temps=t;
    }

    @Override
    public void update() {
        cptAct++;
        if(cptAct==60)
        {
            Platform.runLater(()->{temps--;setTempsP(temps);
                System.out.println(getTempsP());});
            cptAct=0;
        }
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int t){
        temps = t;
    }
}
