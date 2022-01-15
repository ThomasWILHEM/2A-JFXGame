package modele.Utils;

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
        this.c = c;
        dG = new DeplaceurGarde();
        b.Subscribe(this);
    }
    @Override
    public void update() {
        if (cptAct == 30){
            dG.deplacer(c,g,g.getP());
            cptAct =0;
        }
        cptAct++;
    }
}
