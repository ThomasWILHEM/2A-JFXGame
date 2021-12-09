package modele;

public class Garde extends Personnage{
    private int distanceVue;
    public Garde(String sprite,int dist) {
        super(sprite);
        this.distanceVue=dist;
    }
}
