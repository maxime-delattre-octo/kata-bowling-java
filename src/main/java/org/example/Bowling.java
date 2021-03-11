package org.example;

import java.util.stream.IntStream;

public class Bowling {

    public int score(int [][] scores) {
        int finalScore = 0;
        int nbThrowToAdd = 0; // normal
        for(int [] scoresFrame : scores) {
                int currentFrameScore = IntStream.of(scoresFrame).sum();
                finalScore += currentFrameScore;
                if (nbThrowToAdd != 0) {
                    finalScore += IntStream.of(scoresFrame).limit(nbThrowToAdd).sum();
                    nbThrowToAdd -= Math.min(nbThrowToAdd, scoresFrame.length);
                }

                if ( scoresFrame.length == 2 && currentFrameScore == 10 ) {
                    nbThrowToAdd += 1; // spare
                } else if (scoresFrame.length == 1 && currentFrameScore ==10 ) {
                    nbThrowToAdd += 2; // Strike
                }
        }

        return finalScore;
    }
}
