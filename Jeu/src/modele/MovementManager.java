package modele;

import javafx.scene.input.KeyEvent;

public class MovementManager {
    private Carte c;
    private Deplaceur dep;
    private Entity persoJoueur;
    public MovementManager() {
        c = new Carte();
        persoJoueur=c.lireCarte("/home/belabonne/JFX/2A-JFXGame/Jeu/rsrc/Map/map1.txt");
        dep = new Deplaceur();
    }

    public Carte getCarte() {return c;}
    public void gestionTouches(KeyEvent k){
        dep.traitementMouvement(c,persoJoueur,k);
    }
}
