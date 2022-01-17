package modele.Acteurs;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modele.Utils.Position;

public abstract class Entity {
    /**
     * Position de l'entitée
     */
    private Position p;

    /**
     * Sprite de l'entitée
     */
    private ImageView sprite=new ImageView();

    /**
     * Savoir si l'objet est traversable
     */
    boolean isSolid=false;

    public Entity(Image image,Position p,boolean s){
        sprite = new ImageView(image);
        sprite.xProperty().bind(p.posXProperty().multiply(45));
        sprite.yProperty().bind(p.posYProperty().multiply(45));
        this.isSolid = s;
        this.p=p;
    }

    /**
     * Permet de récuperer un sprite
     * @return Une image view
     */
    public ImageView getSprite() {
        return sprite;
    }

    /**
     * Permet de vérifier si l'entitée est solide
     * @return Si solid ou pas
     */
    public boolean isSolid() {
        return isSolid;
    }

    /**
     * Permet de récupérer la position de l'entitée
     * @return Position de l'entitée
     */
    public Position getP() {
        return p;
    }

    /**
     * Permet de set la position de l'entitée
     * @param p Position à set
     */
    public void setP(Position p) {
        this.p = p;
    }
}
