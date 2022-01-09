package modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Position {

    private IntegerProperty posX =  new SimpleIntegerProperty();
    public int getPosX() {return posX.getValue();}
    public void setPosX(int value) { posX.setValue(value);}
    public IntegerProperty posXProperty() { return posX;}

    private IntegerProperty posY =  new SimpleIntegerProperty();
    public int getPosY() {return posY.getValue();}
    public void setPosY(int value) { posY.setValue(value);}
    public IntegerProperty posYProperty() { return posY;}

    public Position(int pX,int pY){
        setPosX(pX);
        setPosY(pY);
    }


    @Override
    public boolean equals(Object o)
    {
        if (o.getClass() == Position.class) {
            if (getPosX() == ((Position)o).getPosX() && getPosY() == ((Position)o).getPosY()) {
                return true;
            }
        }
        return false;
    }
}
