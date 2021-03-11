package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Partie {

    public Integer calculScore(Map<Integer,List<Integer>> frames){
        Integer score = 0;
        List<Map.Entry<Integer,List<Integer>>> frameList = getFramesAsList(frames);

        for(int i=0; i < frameList.size(); i++){
            if(isStrike(frameList.get(i))){
                score += 10;
                score += calculateStrikeBonus(frameList, i);
            } else{
                if(scoreOfFrame(frameList.get(i))==10){
                    score += 10;
                    score += frameList.get(i+1).getValue().get(0);
                }
                else {
                    score += scoreOfFrame(frameList.get(i));
                }
            }
        }

        return score;
    }

    private List<Map.Entry<Integer,List<Integer>>> getFramesAsList(Map<Integer,List<Integer>> frames){
        List<Map.Entry<Integer,List<Integer>>>entries = new ArrayList<>();
        for(Map.Entry entry: frames.entrySet()){
            entries.add(entry);
        }
        entries = entries.stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
        return entries;
    }

    private Integer scoreOfFrame(Map.Entry<Integer,List<Integer>> frame){
        Integer score = 0;
        for(Integer lancer : frame.getValue()){
            score += lancer;
        }
        return score;
    }

    private boolean isStrike(Map.Entry<Integer,List<Integer>> frame){
        if(frame.getValue().get(0)==10)
            return true;
        return false;
    }

    private Integer calculateStrikeBonus(List<Map.Entry<Integer,List<Integer>>> frameList, Integer currentFrameIndex){
        Integer bonus = 0;
        if(currentFrameIndex<frameList.size()-2){
            if(isStrike(frameList.get(currentFrameIndex+1))) {
                bonus += 10 + frameList.get(currentFrameIndex + 2).getValue().get(0);
            }
            else {
                bonus += scoreOfFrame(frameList.get(currentFrameIndex + 1));
            }
        }
        else
            if(currentFrameIndex<frameList.size()-1) {
                bonus += frameList.get(currentFrameIndex + 1).getValue().get(0) + frameList.get(currentFrameIndex + 1).getValue().get(1);
            }
            else {
                bonus += frameList.get(currentFrameIndex).getValue().get(1) + frameList.get(currentFrameIndex).getValue().get(2);
            }

        return bonus;
    }

}
