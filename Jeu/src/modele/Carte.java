package modele;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Carte {
    private int longueurP;
    private int largeurP;

    private HashMap<Entity, Position> elements;

    public HashMap<Entity, Position> getElements() {return elements;}

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

    public void lireCarte(String chemin){
        int i,j;
        LecteurDeCarte l = new LecteurDeCarte();
        try {
            char[][] cLue = l.lireCarte(chemin);
            for(i=0;i<l.getHauteur();i++){
                for(j=0;j<l.getLongueur();j++){
                    switch(cLue[i][j]){
                        case 1 : elements.put(new Mur("/Images/mur.jpeg"),new Position(j,i));
                        case 2 : elements.put(new PersoJoueur("/Images/voleurUnique.png"),new Position(j,i));
                        case 3 : elements.put(new Mur("/Images/mur.jpeg"),new Position(j,i));
                        case 4 : elements.put(new Garde("/Images/voleur.jpg",0),new Position(j,i));
                        default : elements.put(new Objet("/Images/floor_01_1.png"),new Position(j,i));
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("Lecture de carte impossible");
        }
    }
}