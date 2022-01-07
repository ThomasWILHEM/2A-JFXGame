package modele;

import javafx.scene.image.Image;

public abstract class Entity {
    private Image sprite;
    boolean isSolid;
    public Entity(String image,boolean s){
        sprite = new Image(image);
        this.isSolid = s;
    }

    public Image getSprite() {
        return sprite;
    }
    public boolean isSolid() {
        return isSolid;
    }
}
