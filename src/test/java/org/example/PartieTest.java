package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartieTest {

    @Test
    public void scoreEquals0WhenAllFail() {
        FallenPinsProvider provider = new FallenPinsProviderStubScoreZeroTest();
        Partie partie = new Partie(provider);
        assertEquals(0, partie.calculScore());
    }

   @Test
    public void scoreEqualsSumOfThrowWhenThereIsNoStrikeNorSpare() {
       FallenPinsProvider provider = new FallenPinsProviderStubNoStrikeNoSpareTest();
       Partie partie = new Partie(provider);
       assertEquals(1, partie.calculScore());
    }

   @Test
    public void scoreWithOneStrikeAndNoSpare() {
       FallenPinsProvider provider = new FallenPinsProviderStubStrikeNoSpareTest();
       Partie partie = new Partie(provider);
       assertEquals(18, partie.calculScore());
    }

    @Test
    public void scoreWithOnSpareNoStrike() {
        FallenPinsProvider provider = new FallenPinsProviderStubSpareNoStrikeTest();
        Partie partie = new Partie(provider);
        assertEquals(12, partie.calculScore());
    }


    @Test
    public void scoreWithTwoSpareConsecutivelyNoStrike(){
        FallenPinsProvider provider = new FallenPinsProviderStubTwoConsecutiveSpareNoStrikeTest();
        Partie partie = new Partie(provider);
        assertEquals(27, partie.calculScore());
    }

   @Test
    public void scoreWithTwoOrMoreStrikeConsecutivelyNoStrike(){
       FallenPinsProvider provider = new FallenPinsProviderStubTwoConsecutiveStrikeTest();
       Partie partie = new Partie(provider);
       assertEquals(33, partie.calculScore());
        /*assertEquals(93,partie.calculScore(
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
                )));*/
    }

    /*@Test
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
    }*/
}
