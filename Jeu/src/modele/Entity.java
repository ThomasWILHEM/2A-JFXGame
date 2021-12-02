package modele;

import javafx.scene.image.Image;

abstract class Entity {
    private Image sprite;

    public Entity(String image){
        sprite = new Image(image);
    }

    public Image getSprite() {
        return sprite;
    }
}
