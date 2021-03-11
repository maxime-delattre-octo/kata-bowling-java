package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Partie {

    private FallenPinsProvider provider;
    private ScoreConsoleDisplayer scoreConsoleDisplayer;

    public Partie(FallenPinsProvider provider,ScoreConsoleDisplayer scoreConsoleDisplayer) {
        this.provider = provider;
        this.scoreConsoleDisplayer = scoreConsoleDisplayer;
    }

    public Integer calculScore() {
        Integer score = 0;
        List<Map.Entry<Integer, List<Integer>>> frameList = getFrameAsList(buildGameMap());
        for (int i = 0; i < frameList.size(); i++) {
            if (isStrike(frameList.get(i))) {
                score += 10;
                score += calculateStrikeBonus(frameList, i);
            } else {
                if (scoreOfFrame(frameList.get(i)) == 10) {
                    score += 10;
                    score += frameList.get(i + 1).getValue().get(0);
                } else {
                    score += scoreOfFrame(frameList.get(i));
                }
            }
        }
        scoreConsoleDisplayer.displayScoreToConsole(score);
        return score;
    }

    private Map<Integer, List<Integer>> buildGameMap() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            Integer first = provider.getFallenPins();
            if (first == 10){
                if(i<10){
                    map.put(i, List.of(10));
                }else{
                    Integer second = provider.getFallenPins();
                    if (second == 10){
                        map.put(i, List.of(first, second, provider.getFallenPins()));
                    }else {
                        map.put(i, List.of(first, second));
                    }
                }
            }
            else {
                Integer second = provider.getFallenPins();
                if (first + second == 10 && i==10) {
                    map.put(i, List.of(first, second, provider.getFallenPins()));
                } else {
                    map.put(i, List.of(first, second));
                }
            }
        }
        return map;
    }

    private List<Map.Entry<Integer, List<Integer>>> getFrameAsList(Map<Integer, List<Integer>> frames) {
        List<Map.Entry<Integer, List<Integer>>> entries = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : frames.entrySet()) {
            entries.add(entry);
        }
        entries = entries.stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
        return entries;
    }

    private Integer scoreOfFrame(Map.Entry<Integer, List<Integer>> frame) {
        Integer score = 0;
        for (Integer lancer : frame.getValue()) {
            score += lancer;
        }
        return score;
    }

    private boolean isStrike(Map.Entry<Integer, List<Integer>> frame) {
        if (frame.getValue().get(0) == 10)
            return true;
        return false;
    }

    private Integer calculateStrikeBonus(List<Map.Entry<Integer, List<Integer>>> frameList, Integer currentFrameIndex) {
        Integer bonus = 0;
        if (currentFrameIndex < frameList.size() - 2) {
            if (isStrike(frameList.get(currentFrameIndex + 1))) {
                bonus += 10 + frameList.get(currentFrameIndex + 2).getValue().get(0);
            } else {
                bonus += scoreOfFrame(frameList.get(currentFrameIndex + 1));
            }
        } else if (currentFrameIndex < frameList.size() - 1) {
            bonus += frameList.get(currentFrameIndex + 1).getValue().get(0) + frameList.get(currentFrameIndex + 1).getValue().get(1);
        } else {
            bonus += frameList.get(currentFrameIndex).getValue().get(1) + frameList.get(currentFrameIndex).getValue().get(2);
        }

        return bonus;
    }
}
