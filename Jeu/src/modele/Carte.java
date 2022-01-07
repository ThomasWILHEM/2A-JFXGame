package modele;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarOutputStream;

public class Carte {
    private int longueurP;
    private int largeurP;

    private HashMap<Entity, Position> elements;

    public HashMap<Entity, Position> getElements() {return elements;}

    public Carte() {
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


    public Entity lireCarte(String chemin){
        int i,j;
        Entity joueur = new PersoJoueur("/Images/voleurUnique.png");
        LecteurDeCarte l = new LecteurDeCarte();
        try {
            char[][] cLue = l.lireCarte(chemin);
            for(i=0;i<l.getHauteur();i++){
                for(j=0;j<l.getLongueur();j++){
                    switch(cLue[i][j]){
                        case '1' : elements.put(new Mur("/Images/mur.png"),new Position(j,i));break;
                        case '2' : elements.put(joueur,new Position(j,i));break;
                        case '3' : elements.put(new Mur("/Images/floor_01_1.png"),new Position(j,i));break;
                        case '4' : elements.put(new Garde("/Images/garde.png",0),new Position(j,i));break;
                    }
                }
                longueurP = j;
            }
            largeurP = i;

        }
        catch(Exception e){
            System.out.println("Lecture de carte impossible");
        }
        return joueur;
    }
}