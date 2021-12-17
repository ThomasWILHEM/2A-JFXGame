public class Main {

    public static void main(String[] args){
        gestTemps g = new gestTemps();
        BoucleurJeu b = new BoucleurJeu(g);
        BoucleurJeu b2 = new BoucleurJeu(g);
        Thread t1 = new Thread(b);
        Thread t2 = new Thread(b2);
        t1.start();
        t2.start();
    }
}
