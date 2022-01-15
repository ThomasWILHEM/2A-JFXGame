package modele.Boucleurs;

public class BoucleurJeu extends Boucleur {

    public BoucleurJeu(){
    }
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(16);
            } catch (Exception e) {

            }
            notifie();
        }
    }
}
