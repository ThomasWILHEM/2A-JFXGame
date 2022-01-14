package modele;

import javafx.scene.image.Image;

public class VueGarde extends Entity{

    Garde gardePossesseur;

    public Garde getGardePossesseur() {
        return gardePossesseur;
    }

    public VueGarde(Image image, Position p, Garde g) {
        super(image, p, true);
        gardePossesseur=g;
    }
}
