package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PartieTest {

    @Mock
    ScoreConsoleDisplayer scoreConsoleDisplayer;

    @Test
    public void scoreReturn0WhenAllFail() {
        FallenPinsProvider provider = new FallenPinsProviderStubScoreZeroTest();
        Partie partie = new Partie(provider,scoreConsoleDisplayer);
        assertEquals(0, partie.calculScore());
    }

   @Test
    public void scoreEqualsSumOfThrowWhenThereIsNoStrikeNorSpare() {
       FallenPinsProvider provider = new FallenPinsProviderStubNoStrikeNoSpareTest();
       Partie partie = new Partie(provider,scoreConsoleDisplayer);
       assertEquals(1, partie.calculScore());
   }

   @Test
    public void scoreWithOneStrikeAndNoSpare() {
       FallenPinsProvider provider = new FallenPinsProviderStubStrikeNoSpareTest();
       Partie partie = new Partie(provider,scoreConsoleDisplayer);
       assertEquals(18, partie.calculScore());
   }

    @Test
    public void scoreWithOnSpareNoStrike() {
        FallenPinsProvider provider = new FallenPinsProviderStubSpareNoStrikeTest();
        Partie partie = new Partie(provider,scoreConsoleDisplayer);
        assertEquals(12, partie.calculScore());
    }


    @Test
    public void scoreWithTwoSpareConsecutivelyNoStrike(){
        FallenPinsProvider provider = new FallenPinsProviderStubTwoConsecutiveSpareNoStrikeTest();
        Partie partie = new Partie(provider,scoreConsoleDisplayer);
        assertEquals(27, partie.calculScore());

    }

   @Test
    public void scoreWithTwoOrMoreStrikeConsecutivelyNoStrike(){
       FallenPinsProvider provider = new FallenPinsProviderStubTwoConsecutiveStrikeTest();
       Partie partie = new Partie(provider,scoreConsoleDisplayer);
       assertEquals(33, partie.calculScore());

   }

    @Test
    public void scoreWithSpareOnLastFrame(){
       FallenPinsProvider provider = new FallenPinsProviderStubSpareOnLastFrameTest();
       Partie partie = new Partie(provider,scoreConsoleDisplayer);
       assertEquals(42, partie.calculScore());
    }

    @Test
    public void scoreReturn300WithPerfectGame(){
       FallenPinsProvider provider = new FallenPinsProviderStubPerfectGameTest();
       Partie partie = new Partie(provider,scoreConsoleDisplayer);
       assertEquals(300, partie.calculScore());
    }

    @Test
    public void displayScoreTest(){
        FallenPinsProvider provider = new FallenPinsProviderStubPerfectGameTest();
        Partie partie = new Partie(provider,scoreConsoleDisplayer);
        partie.calculScore();
        Mockito.verify(scoreConsoleDisplayer).displayScoreToConsole(300);
    }
}
