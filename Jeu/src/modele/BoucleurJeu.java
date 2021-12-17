package modele;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.binding.Binding;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;

public class BoucleurJeu extends Boucleur {

    public gestTemps g;
    public BoucleurJeu(gestTemps ge)
    {
        g = ge;
    }
    @Override
    public void run() {
        try {
            g.setTimer(g.getTimer()-1);
            Thread.sleep(1000);
        }
        catch(Exception e) {

        }
        Platform.runLater(()->{notifie();});
    }
    public void notifie() {
        for(Observateur o:obs)
        {
            o.update();
        }
    }

}
