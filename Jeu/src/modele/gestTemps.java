package modele;

public class gestTemps implements Observateur {
    private int timer;

    public gestTemps(){
        timer = 90;
    }
    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    @Override
    public void update() {
        timer--;
    }
}
