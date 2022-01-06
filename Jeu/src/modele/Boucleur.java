package modele;

import java.util.ArrayList;
import java.util.List;

public abstract class Boucleur implements Runnable{
    public List<Observateur> obs;
    public Boucleur(){
        obs = new ArrayList<>();
    }
    public void Subscribe(Observateur o) {
        obs.add(o);
    }
    public void notifie() {
        for(Observateur o:obs)
        {
            o.update();
        }
    }
}
