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

    private Garde g;
    private Carte c;
    private DeplaceurGarde dG;
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
        if (cptAct == 30){
            if(dG.deplacer(c,g,g.getP()) == 1){
                try {
                    Platform.runLater(()->{
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
            cptAct =0;
        }
        cptAct++;
    }
}
