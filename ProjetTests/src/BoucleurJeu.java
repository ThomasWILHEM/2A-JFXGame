public class BoucleurJeu extends Boucleur{
    public gestTemps g;

    public BoucleurJeu(gestTemps gest){
        g = gest;
    }

    @Override
    public void run() {
        while(true) {
            try {
                System.out.println("Boucleur");
                g.timer = g.timer - 1;
                System.out.println(g.timer);
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Problème sleep");
            }
        }
    }
}
