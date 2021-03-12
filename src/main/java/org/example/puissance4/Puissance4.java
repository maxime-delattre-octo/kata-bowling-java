package org.example.puissance4;

import org.example.ScoreConsoleDisplayer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Puissance4 {

    List<List<String>> grille;
    String dernierJetonJoue;

    public Puissance4(){

        initGrille();
    }

    public void vider(){
        initGrille();
    }

    private void initGrille(){
        grille = new ArrayList();
        for(int i=0;i<6;i++) {
            List<String> ligne = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                ligne.add(".");
            }
            grille.add(ligne);
        }
    }

    public boolean ajouterJeton(Integer colonne, String joueur){
        System.out.println(joueur + " joue en " + colonne);
        boolean coup_autorise = true;
        if(joueur.equals(dernierJetonJoue)) {
            return false;
        }
        else {
            dernierJetonJoue = joueur;
        }

        if(isFinished()) {
            return false;
        }

        int ligne = 5;
        while(!grille.get(ligne).get(colonne-1).equals(".") && ligne>=0){
            ligne--;
        }
        grille.get(ligne).set(colonne-1,joueur);

        if(coup_autorise)
            System.out.println(this.toString());

        return coup_autorise;
    }

    public boolean isFinished() {
        int colonne = 0;
        int cpt = 0;
        String old_value = ".";
        String value;
        //Test la victoire verticale
        for(int ligne=5; ligne>=0; ligne--){
            value = grille.get(ligne).get(colonne);
            if(value.equals(old_value) && !old_value.equals(".")){
                cpt++;
            }
            else {
                cpt=1;
                old_value=value;
            }

            if(cpt==4) {
                System.out.println(value + " a gagné !");
                return true;
            }
        }
        cpt = 0;
        old_value = ".";
        //Test la victoire horizontale
        for(int ligne=5; ligne>=0; ligne--){
            List<String> line = grille.get(ligne);
            for(int col=0; col<7; col++){
                value =line.get(col);
                if(value.equals(old_value) && !old_value.equals(".")){
                    cpt++;
                }
                else {
                    cpt=1;
                    old_value=value;
                }

                if(cpt==4) {
                    System.out.println(value + " a gagné !");
                    return true;
                }
            }
        }

        //Test la victoire diagonale montante droite
        for(int ligne=5; ligne>=3; ligne--){
            List<String> line = grille.get(ligne);
            for(int col=0; col<=3; col++){
                value =line.get(col);
                if(!value.equals(".")){
                    boolean ok = true;
                    for(int i=1; i<4; i++){
                        if(!grille.get(ligne-i).get(col+i).equals(value)) {
                            ok = false;
                        }
                    }
                    if(ok) {
                        System.out.println(value + " a gagné !");
                        return true;
                    }
                }
            }
        }

        //Test la victoire diagonale montante gauche
        for(int ligne=5; ligne>=3; ligne--){
            List<String> line = grille.get(ligne);
            for(int col=6; col>=3; col--){
                value =line.get(col);
                if(!value.equals(".")){
                    boolean ok = true;
                    for(int i=1; i<4; i++){
                        if(!grille.get(ligne-i).get(col-i).equals(value)) {
                            ok = false;
                        }
                    }
                    if(ok) {
                        System.out.println(value + " a gagné !");
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public String toString(){
        return grille.stream()
                .map(ligne ->
                        ligne.stream().collect(Collectors.joining(" ","","\n"))
                )
                .collect(Collectors.joining());
    }

}
