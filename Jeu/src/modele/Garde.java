package modele;

public class Garde extends Personnage{
        private ChampVision champVision;

        public Garde(String sprite,int dist,int angle) {
            super(sprite);
            champVision = new ChampVision(dist,angle);
        }
}
