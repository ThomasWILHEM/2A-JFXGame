package modele;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Carte {
    private int longueurP;
    private int largeurP;
    private HashMap<Entity, Position> elements;

    public Carte(int lp, int larP) {
        this.largeurP = larP;
        this.longueurP = lp;
        elements = new HashMap<Entity, Position>();
    }

    //Mise a jour en whatIsAt, car sinon je peux pas vérifier la transparence de l'entité
    Entity whatIsAt(Position pVoulue) {
        if(elements.containsValue(pVoulue)){
            Set<Map.Entry<Entity,Position>> recherche = elements.entrySet();
            for(Map.Entry<Entity,Position> ent:recherche){
                if(ent.getValue() == pVoulue)
                {
                    return ent.getKey();
                }
            }
        }
        return null;
    }
}