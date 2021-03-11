package org.example.puissance4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Puissance4 {

    List<List<String>> grille;

    public Puissance4(){
        grille = new ArrayList();
        for(int i=0;i<6;i++){
            List<String> ligne = new ArrayList<>();
            for(int j = 0;j<7;j++){
                ligne.add(".");
            }
            grille.add(ligne);
        }
    }

    public void ajouterJeton(Integer colonne, String joueur){
        int ligne = 5;
        while(!grille.get(ligne).get(colonne-1).equals(".") && ligne>=0){
            ligne--;
        }
        grille.get(ligne).set(colonne-1,joueur);
    }

    public String toString(){
        return grille.stream()
                .map(ligne ->
                        ligne.stream().collect(Collectors.joining(" ","","\n"))
                )
                .collect(Collectors.joining());
    }

}
