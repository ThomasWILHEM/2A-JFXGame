package modele;

public class Position {
    private int posX;
    private int posY;

    public Position(int pX,int pY){
        this.posX = pX;
        this.posY = pY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o.getClass() == Position.class) {
            if (posX == ((Position)o).getPosX() && posY == ((Position)o).getPosY()) {
                return true;
            }
        }
        return false;
    }
}
