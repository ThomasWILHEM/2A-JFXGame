package modele.Boucleurs;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import modele.Observateur;

import java.util.ArrayList;
import java.util.List;

public abstract class Boucleur implements Runnable{

    private BooleanProperty gameOver =  new SimpleBooleanProperty();
    public boolean getGameOver() {return gameOver.getValue();}
    public void setGameOver(boolean value) { gameOver.setValue(value);}
    public BooleanProperty gameOverProperty() { return gameOver;}


    public List<Observateur> obs;
    public Boucleur(){
        obs = new ArrayList<>();
    }
    public void Subscribe(Observateur o) {
        obs.add(o);
    }
    public void notifie() {
        for(Observateur o:obs)
        {
            o.update();
        }
    }
}
