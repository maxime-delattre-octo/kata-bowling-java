package org.example;

import java.util.Random;

public class FallenPinsProvider {

    public Integer getFallenPins() {
        return new Random().nextInt(10) + 1;
    }
}
