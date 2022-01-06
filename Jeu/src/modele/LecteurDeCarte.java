package modele;

import java.io.*;

public class LecteurDeCarte {
    private int longueur =0;
    private int hauteur =0;

    public char [][] lireCarte(String chemin) throws FileNotFoundException {
        char[][] carte = new char[11][34];
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
