package modele.Utils;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import modele.Acteurs.*;

public class Carte {

    private int longueurP;
    private int largeurP;

    /**
     * Liste des entitées
     */
    private ObservableList<Entity> elements;

    public ObservableList<Entity> getElements() {return elements;}

    public int getLongueurP() {
        return longueurP;
    }

    public int getLargeurP() {
        return largeurP;
    }

    public Carte() {
        elements = FXCollections.observableArrayList();
    }

    /**
     * Permet de détruire un objet
     * @param o Objet à détruire
     */
    public void destroy(Objet o){
        Platform.runLater(()->{elements.remove(o);});
    }

    /**
     * Permet de vider la collection d'entitée
     */
    public void clearCarte(){
            elements.clear();
    }

    /**
     * Charge un nouveau Niveau en fonction du nombre envoyé en paramètre
     * @param numLevel
     */
    public void loadNewLevel(int numLevel){
        clearCarte();
        lireCarte("rsrc/Map/map"+numLevel+".txt");
    }

    /**
     * Permet d'enlever toutes les vueGardes de la collection d'entitée
     * @param g
     */
    public void clearVueGarde(Garde g){
        Platform.runLater(()->{
            elements.removeIf(entity -> entity.getClass()== VueGarde.class && ((VueGarde) entity).getGardePossesseur().equals(g));
        });

    }

    /**
     * Permet de remplire la collection d'entitée de la carte
     * @param chemin
     */
    public void lireCarte(String chemin){
        int i,j;
        LecteurDeCarte l = new LecteurDeCarte();
        try {
            char[][] cLue = l.lireCarte(chemin);
            for(i=0;i<l.getHauteur();i++){
                for(j=0;j<l.getLongueur();j++){
                    switch(cLue[i][j]){
                        case '1' : elements.add(new Mur(new Image("/Images/mur.png"),new Position(j,i)));break;
                        case '2' : elements.add(new PersoJoueur(new Image("/Images/voleurUnique.png"),new Position(j,i),'U'));break;
                        case '3' : elements.add(new Sortie(new Image("/Images/floor_01_1.png"),new Position(j,i)));break;
                        case '4' : elements.add(new Garde(new Image("/Images/garde.png"),2,new Position(j,i),'U'));break;
                        case '5' : elements.add(new Objet(new Image("/Images/gems.png"),new Position(j,i)));break;
                    }
                }
                longueurP = j;
            }
            largeurP = i;

        }
        catch(Exception e){
            System.out.println("Lecture de carte impossible");
            System.out.println(e.getCause());
        }
    }


}