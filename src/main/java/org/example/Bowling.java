package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Bowling {

    private RollProvider rollProvider;
    private ConsoleDisplayer consoleDisplayer;

    public Bowling(RollProvider rollProvider, ConsoleDisplayer consoleDisplayer) {
        this.rollProvider = rollProvider;
        this.consoleDisplayer = consoleDisplayer;
    }

    
    public int score() {
        int [][] scores = this.getScoreAsList();
        int finalScore = 0;
        int nbThrowToAdd = 0; // normal

        for(int i =0; i < 10; i++) {
            int [] scoresFrame = scores[i];
            int currentFrameScore = IntStream.of(scoresFrame).sum();
            finalScore += currentFrameScore;
            if (nbThrowToAdd != 0) {
                List<Integer> scoreList = new ArrayList<>();
                IntStream.of(scoresFrame).forEach(s ->scoreList.add(s));
                if (scoresFrame.length < nbThrowToAdd && i < 9) {
                    IntStream.of(scores[i+1]).forEach(s ->scoreList.add(s));
                } 
                finalScore += scoreList.stream().mapToInt(Integer::intValue).limit(nbThrowToAdd).sum();
                nbThrowToAdd = 0;
            }

            if ( scoresFrame.length == 2 && currentFrameScore == 10 ) {
                nbThrowToAdd = 1; // spare
            } else if (scoresFrame.length == 1 && currentFrameScore ==10 ) {
                nbThrowToAdd = 2; // Strike
            }
        }
        
        this.consoleDisplayer.displayScoreToConsole(finalScore);
        return finalScore;
    }

    public int scoreWithGivenList(int [][] scores) {
        int finalScore = 0;
        int nbThrowToAdd = 0; // normal

        for(int i =0; i < 10; i++) {
            int [] scoresFrame = scores[i];
            int currentFrameScore = IntStream.of(scoresFrame).sum();
            finalScore += currentFrameScore;
            if (nbThrowToAdd != 0) {
                List<Integer> scoreList = new ArrayList<>();
                IntStream.of(scoresFrame).forEach(s ->scoreList.add(s));
                if (scoresFrame.length < nbThrowToAdd && i < 9) {
                    IntStream.of(scores[i+1]).forEach(s ->scoreList.add(s));
                } 
                finalScore += scoreList.stream().mapToInt(Integer::intValue).limit(nbThrowToAdd).sum();
                nbThrowToAdd = 0;
            }

            if ( scoresFrame.length == 2 && currentFrameScore == 10 ) {
                nbThrowToAdd = 1; // spare
            } else if (scoresFrame.length == 1 && currentFrameScore ==10 ) {
                nbThrowToAdd = 2; // Strike
            }
        }

        this.consoleDisplayer.displayScoreToConsole(finalScore);
        return finalScore;
    }

    private int [][] getScoreAsList() {
        int[][] allscores =  new int[10][];
        for(int i =0; i<10 ; i++) {
            int score = this.rollProvider.getRoll();
            if (score == 10) {
                if (i != 9) {
                    int[] framescore = {score};
                    allscores[i] = framescore;
                } else {
                    int secondThrow = this.rollProvider.getRoll();
                    if ( secondThrow == 10) {
                        int[] framescore = {
                            score,
                            secondThrow,
                            this.rollProvider.getRoll()
                        };
                        allscores[i] = framescore;
                    } else {
                        int ThirdThrow = Math.min(10-secondThrow, this.rollProvider.getRoll());

                        int[] framescore = {
                            score,
                            secondThrow,
                            ThirdThrow
                        };
                        allscores[i] = framescore;
                    }
                    
                }
            } else {
                int secondScore = Math.min(10-score, this.rollProvider.getRoll());
            
                if (i == 9 && score + secondScore == 10) {
                    int[] tenFramescore = {score, secondScore, this.rollProvider.getRoll()};
                    allscores[i] = tenFramescore;
                } else {
                    int[] framescore = {score, secondScore};
                    allscores[i] = framescore;
                }
            } 
        }
        return allscores;
    }
}
