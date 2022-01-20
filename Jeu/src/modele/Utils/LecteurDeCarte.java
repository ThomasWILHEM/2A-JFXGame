package modele.Utils;

import java.io.*;

public class LecteurDeCarte {
    private int longueur =0;
    private int hauteur =0;

    /**
     * Permet de lire une carte depuis un fichier texte
     * @param chemin Chemin du fichier texte
     * @return Tableau de char représentant la carte
     * @throws FileNotFoundException
     */
    public char [][] lireCarte(String chemin) throws FileNotFoundException {
        char[][] carte = new char[50][50]; //Taille maximale des cartes
        String line;
        int i=0,j=0;
        try(BufferedReader br = new BufferedReader(new FileReader(chemin))){
            while((line = br.readLine())!=null){
                for(char num : line.toCharArray()){
                    carte[i][j] = num;
                    j++;
                }
                longueur = j;
                j=0;
                i++;
            }
            hauteur = i;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return carte;
    }

    public int getLongueur() {
        return longueur;
    }

    public int getHauteur() {
        return hauteur;
    }

}
