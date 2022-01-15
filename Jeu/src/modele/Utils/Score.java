package modele.Utils;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Score {

    public Score() {
        setCounterP(0);
    }

    private IntegerProperty counterP =  new SimpleIntegerProperty();
    public int getCounterP() {return counterP.getValue();}
    public void setCounterP(int value) { counterP.setValue(value);}
    public IntegerProperty CounterProperty() { return counterP;}


    public void addScore(int value){
        setCounterP(getCounterP()+value);
    }
}
