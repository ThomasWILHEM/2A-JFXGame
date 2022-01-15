package modele.Utils;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import modele.Acteurs.*;

public class Carte {
    private int longueurP;
    private int largeurP;



    private ObservableList<Entity> elements;

    public ObservableList<Entity> getElements() {return elements;}

    public Carte() {
        elements = FXCollections.observableArrayList();
    }

    //Mise a jour en whatIsAt, car sinon je peux pas vérifier la transparence de l'entité


    public void destroy(Objet o){
        //o.setSprite(null);
        Platform.runLater(()->{elements.remove(o);});
    }

    public void clearCarte(){
        elements.clear();
    }

    public void clearVueGarde(Garde g){
        Platform.runLater(()->{
            elements.removeIf(entity -> entity.getClass()== VueGarde.class && ((VueGarde) entity).getGardePossesseur().equals(g));
        });

    }

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