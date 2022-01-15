package modele.Boucleurs;

public class BoucleurGarde extends Boucleur{

    public BoucleurGarde(){}
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(40);
            } catch (Exception e) {

            }
            notifie();
        }
    }
}
