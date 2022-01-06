package modele;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.binding.Binding;
import javafx.beans.value.ChangeListener;
import javafx.collections.ObservableList;

public class BoucleurJeu extends Boucleur {

    public BoucleurJeu(){
    }
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(16);
            } catch (Exception e) {

            }
            notifie();
        }
    }
}
