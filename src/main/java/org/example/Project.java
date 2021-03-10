package org.example;

import java.util.*;

public class Project {

    public Project(){
    }

    public int score(List<List<Integer>> scores) {
        int finalScore = 0;
        for(List<Integer> scoreFrame : scores) {
            for (Integer scoreLance : scoreFrame) {
                finalScore += scoreLance;
            }
        }

        return finalScore;
    }
}
