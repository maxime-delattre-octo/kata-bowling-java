package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartieTest {

    Partie partie = new Partie();

    @Test
    public void scoreEquals0WhenAllFail(){
        assertEquals(0,partie.calculScore(List.of(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)));
    }

    @Test
    public void scoreEqualsSumOfThrowWhenThereIsNoStrikeNorSpare(){
        assertEquals(1,partie.calculScore(List.of(1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)));
    }

    
}
