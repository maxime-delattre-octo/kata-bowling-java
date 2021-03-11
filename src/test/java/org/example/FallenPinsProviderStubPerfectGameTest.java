package org.example;

import java.util.List;
import java.util.Map;

public class FallenPinsProviderStubPerfectGameTest extends FallenPinsProvider {

    private Integer frameId = 1;
    private Integer shotId = 0;
    private Map<Integer, List<Integer>> gameMap = Map.of(
            1, List.of(10),
            2, List.of(10),
            3, List.of(10),
            4, List.of(10),
            5, List.of(10),
            6, List.of(10),
            7, List.of(10),
            8, List.of(10),
            9, List.of(10),
            10, List.of(10,10,10)
            );

    @Override
    public Integer getFallenPins() {
        Integer fallenPins = gameMap.get(frameId).get(shotId);
        if(fallenPins == 10 && frameId < 10){
            shotId = 0;
            frameId++;
        }else if ((shotId == 0 && frameId < 10) || frameId == 10) {
            shotId++;
        } else if (shotId == 1 && frameId < 10) {
            shotId = 0;
            frameId++;
        }
        return fallenPins;
    }
}
