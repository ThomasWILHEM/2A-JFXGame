package modele;

import java.io.*;

public class LecteurDeCarte {

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
                j=0;
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return carte;
    }
}
