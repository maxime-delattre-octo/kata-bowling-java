package org.example;

import java.util.List;
import java.util.Map;

public class FallenPinsProviderStubSpareOnLastFrameTest extends FallenPinsProvider {

    private Integer frameId = 1;
    private Integer shotId = 0;
    private Map<Integer, List<Integer>> gameMap = Map.of(
            1, List.of(5,5),
            2, List.of(5,5),
            3, List.of(1,0),
            4, List.of(0,0),
            5, List.of(0,0),
            6, List.of(0,0),
            7, List.of(0,0),
            8, List.of(0,0),
            9, List.of(0,0),
            10, List.of(5,5,5)
            );

    @Override
    public Integer getFallenPins() {
        Integer fallenPins = gameMap.get(frameId).get(shotId);
        if(fallenPins == 10){
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
