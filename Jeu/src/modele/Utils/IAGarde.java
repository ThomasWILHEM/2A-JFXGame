package modele.Utils;

import Launcher.Main;
import javafx.application.Platform;
import modele.Acteurs.Entity;
import modele.Acteurs.PersoJoueur;
import modele.Boucleurs.BoucleurJeu;
import modele.Deplaceurs.DeplaceurGarde;
import modele.Acteurs.Garde;
import modele.Observateur;

public class IAGarde implements Observateur {

    /**
     * Garde utilisé
     */
    private Garde g;

    /**
     * Carte
     */
    private Carte c;

    /**
     * Déplaceur garde
     */
    private DeplaceurGarde dG;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    private boolean isActive=true;

    BoucleurJeu b;
    int cptAct =0;

    public IAGarde(Carte c,BoucleurJeu b,Garde g){
        this.g = g;
        this.b = b;
        this.c = c;
        dG = null;
        for(Entity ent : c.getElements()){
            if (ent.getClass() == PersoJoueur.class)
                dG = new DeplaceurGarde((PersoJoueur) ent);
        }
        b.Subscribe(this);
    }

    @Override
    public void update() {
        if(isActive) {
            if (cptAct == 30) {
                if (dG.deplacer(c, g, g.getP()) == 1) {
                    try {
                        Platform.runLater(() -> {
                            try {
                                Main.mg.showVue("/FXML/GameOver.fxml");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });
                        b.setGameOver(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                cptAct = 0;
            }
            cptAct++;
        }
    }
}
