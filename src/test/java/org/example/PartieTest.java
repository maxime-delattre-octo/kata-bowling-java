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
    }

    @Test
    public void scoreWithSpareOnLastFrame(){

       FallenPinsProvider provider = new FallenPinsProviderStubSpareOnLastFrameTest();
       Partie partie = new Partie(provider);
       assertEquals(42, partie.calculScore());

    }

    @Test
    public void scoreWithPerfectGame(){
       FallenPinsProvider provider = new FallenPinsProviderStubPerfectGameTest();
       Partie partie = new Partie(provider);
       assertEquals(300, partie.calculScore());
    }
}
