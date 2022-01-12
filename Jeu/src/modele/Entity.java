package modele;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Entity {
    private Position p;
    private ImageView sprite=new ImageView();
    boolean isSolid=false;

    public Entity(Image image,Position p,boolean s){
        sprite = new ImageView(image);
        sprite.xProperty().bind(p.posXProperty().multiply(45));
        sprite.yProperty().bind(p.posYProperty().multiply(45));
        this.isSolid = s;
        this.p=p;
    }

    public ImageView getSprite() {
        return sprite;
    }
    public boolean isSolid() {
        return isSolid;
    }

    public Position getP() {
        return p;
    }

    public void setP(Position p) {
        this.p = p;
    }
}
