package org.example;

import java.util.List;

public class Partie {

    public Integer calculScore(List<Integer> lancers){
        Integer score = 0;
        for(Integer lancer:lancers){
            score+=lancer;
        }
        return score;
    }

}
