package org.example;

import java.util.Random;

public class RollProvider {

    public Integer getRoll() {
        return new Random().nextInt(10) + 1;
    }
}
