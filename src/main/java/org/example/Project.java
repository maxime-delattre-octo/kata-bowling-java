package org.example;

import java.util.stream.IntStream;

public class Project {

    public Project(){
    }

    public int score(int [][] scores) {
        int finalScore = 0;
        int status = 0; // normal
        for(int [] scoresFrame : scores) {
                int scoreFrameTotal = IntStream.of(scoresFrame).sum();
                finalScore += scoreFrameTotal;
                if (status != 0) {
                    finalScore += IntStream.of(scoresFrame).limit(status).sum();
                    status -= Math.min(status, scoresFrame.length);
                }

                if ( scoresFrame.length == 2 && scoreFrameTotal == 10 ) {
                    status += 1; // spare
                } else if (scoresFrame.length == 1 && scoreFrameTotal ==10 ) {
                    status += 2; // Strike
                }
        }

        return finalScore;
    }
}
