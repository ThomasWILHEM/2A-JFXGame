package modele.Acteurs;

import javafx.scene.image.Image;
import modele.Utils.Position;

public class VueGarde extends Entity{

    Garde gardePossesseur;

    public Garde getGardePossesseur() {
        return gardePossesseur;
    }

    public VueGarde(Image image, Position p, Garde g) {
        super(image, p, false);
        gardePossesseur=g;
    }
}
