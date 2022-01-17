package modele.Utils;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Score {

    /**
     * Score (en int)
     */
    int score;

    public Score() {
        score=0;
        setCounterP("Score : " + score);
    }

    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Score (en StrinProperty) pour pouvoir afficher correctement
     */
    private StringProperty counterP = new SimpleStringProperty();
    public String getCounterP() {return counterP.getValue();}
    public void setCounterP(String value) { counterP.setValue(value);}
    public StringProperty CounterProperty() { return counterP;}

    /**
     * Permet d'actualiser le String du score pour la vue
     */
    public void actualizeScore(){
        setCounterP("Score : " + score);
    }

    /**
     * Permet d'ajouter une valeur au score
     * @param value Valeur à ajouter
     */
    public void addScore(int value){
        setScore(score+value);
    }
}
