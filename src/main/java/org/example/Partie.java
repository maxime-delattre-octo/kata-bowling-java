package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Partie {

    public Integer calculScore(Map<Integer,List<Integer>> frames){
        Integer score = 0;
        List<Map.Entry<Integer,List<Integer>>> frameList = getFramesAsList(frames);

        for(int i=0; i < frameList.size(); i++){
            if(frameList.get(i).getValue().size()==1){
                score += 10;
                for(Integer lancer : frameList.get(i+1).getValue()){
                    score += lancer;
                }
            }else{
                for(Integer lancer : frameList.get(i).getValue()){
                    score += lancer;
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
        return entries;
    }

}
