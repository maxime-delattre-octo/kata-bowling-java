package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartieTest {

    Partie partie = new Partie();

    @Test
    public void scoreEquals0WhenAllFail(){
        assertEquals(0,partie.calculScore(
                Map.of(
                        1, List.of(0,0),
                        2, List.of(0,0),
                        3, List.of(0,0),
                        4, List.of(0,0),
                        5, List.of(0,0),
                        6, List.of(0,0),
                        7, List.of(0,0),
                        8, List.of(0,0),
                        9, List.of(0,0),
                        10, List.of(0,0)
                )));
    }

    @Test
    public void scoreEqualsSumOfThrowWhenThereIsNoStrikeNorSpare(){
        assertEquals(1,partie.calculScore(
                Map.of(
                        1, List.of(1,0),
                        2, List.of(0,0),
                        3, List.of(0,0),
                        4, List.of(0,0),
                        5, List.of(0,0),
                        6, List.of(0,0),
                        7, List.of(0,0),
                        8, List.of(0,0),
                        9, List.of(0,0),
                        10, List.of(0,0)
                )));
    }

    @Test
    public void scoreWithOneStrikeNoSpare(){
        assertEquals(18,partie.calculScore(
                Map.of(
                        1, List.of(10),
                        2, List.of(3,1),
                        3, List.of(0,0),
                        4, List.of(0,0),
                        5, List.of(0,0),
                        6, List.of(0,0),
                        7, List.of(0,0),
                        8, List.of(0,0),
                        9, List.of(0,0),
                        10, List.of(0,0)
                )));
    }

    @Test
    public void scoreWithOneSpareNoStrike(){
        assertEquals(12,partie.calculScore(
                Map.of(
                        1, List.of(5,5),
                        2, List.of(1,0),
                        3, List.of(0,0),
                        4, List.of(0,0),
                        5, List.of(0,0),
                        6, List.of(0,0),
                        7, List.of(0,0),
                        8, List.of(0,0),
                        9, List.of(0,0),
                        10, List.of(0,0)
                )));
    }

    @Test
    public void scoreWithTwoSpareConsecutivelyNoStrike(){
        assertEquals(27,partie.calculScore(
                Map.of(
                        1, List.of(5,5),
                        2, List.of(5,5),
                        3, List.of(1,0),
                        4, List.of(0,0),
                        5, List.of(0,0),
                        6, List.of(0,0),
                        7, List.of(0,0),
                        8, List.of(0,0),
                        9, List.of(0,0),
                        10, List.of(0,0)
                )));
    }

    @Test
    public void scoreWithTwoOrMoreStrikeConsecutivelyNoStrike(){
        assertEquals(33,partie.calculScore(
                Map.of(
                        1, List.of(10),
                        2, List.of(10),
                        3, List.of(1,0),
                        4, List.of(0,0),
                        5, List.of(0,0),
                        6, List.of(0,0),
                        7, List.of(0,0),
                        8, List.of(0,0),
                        9, List.of(0,0),
                        10, List.of(0,0)
                )));
        assertEquals(93,partie.calculScore(
                Map.of(
                        1, List.of(10),
                        2, List.of(10),
                        3, List.of(10),
                        4, List.of(10),
                        5, List.of(1,0),
                        6, List.of(0,0),
                        7, List.of(0,0),
                        8, List.of(0,0),
                        9, List.of(0,0),
                        10, List.of(0,0)
                )));
    }

    @Test
    public void scoreWithSpareOnLastFrame(){
        assertEquals(42,partie.calculScore(
                Map.of(
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
                )));
    }

    @Test
    public void scoreWithPerfectGame(){
        assertEquals(300,partie.calculScore(
                Map.of(
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
                )));
    }
}
