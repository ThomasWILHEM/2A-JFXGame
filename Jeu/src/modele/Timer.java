package modele;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

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
            });
            cptAct=0;
        }
    }
}
