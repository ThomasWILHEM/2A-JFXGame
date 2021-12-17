package modele;

import java.util.Set;

public abstract class Boucleur implements Runnable{
    public Set<Observateur> obs;
}
