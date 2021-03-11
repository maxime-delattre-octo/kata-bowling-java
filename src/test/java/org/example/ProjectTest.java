package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.BDDMockito;
import org.mockito.Mockito;


public class ProjectTest {

    @Test
    public void testNormal() {
        RollProviderStub rollProviderStub = new RollProviderStub(10);
        Bowling project = new Bowling(rollProviderStub);

        int finalScore = 20;
        int [][] scores = {
            {1,1},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
        };
        assertEquals(finalScore, project.scoreWithGivenList(scores));
    }

    @Test
    public void testSpare() {
        RollProviderStub rollProviderStub = new RollProviderStub(10);
        Bowling project = new Bowling(rollProviderStub);

        int finalScore = 29;
        int [][] scores = {
            {5,5},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
        };
        assertEquals(finalScore, project.scoreWithGivenList(scores));
    }

    @Test
    public void testSpareTwice() {
        RollProviderStub rollProviderStub = new RollProviderStub(10);
        Bowling project = new Bowling(rollProviderStub);

        int finalScore = 42;
        int [][] scores = {
            {5,5},
            {5,5},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
        };
        assertEquals(finalScore, project.scoreWithGivenList(scores));
    }

    @Test
    public void testStrike() {
        RollProviderStub rollProviderStub = new RollProviderStub(10);
        Bowling project = new Bowling(rollProviderStub);

        int finalScore = 30;
        int [][] scores = {
            {10},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
        };
        assertEquals(finalScore, project.scoreWithGivenList(scores));
    }

    @Test
    public void testStrikeTwice() {
        RollProviderStub rollProviderStub = new RollProviderStub(10);
        Bowling project = new Bowling(rollProviderStub);

        int finalScore = 49;
        int [][] scores = {
            {10},
            {10},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
            {1,1},
        };
        assertEquals(finalScore, project.scoreWithGivenList(scores));
    }

    @Test
    public void testMixedSpareStrike() {
        RollProviderStub rollProviderStub = new RollProviderStub(10);
        Bowling project = new Bowling(rollProviderStub);

        int finalScore = 128;
        int [][] scores = {
            {10},
            {5,4},
            {10},
            {9,1},
            {10},
            {5,5},
            {0,0},
            {10},
            {4,5},
            {1,1},
        };

        assertEquals(finalScore, project.scoreWithGivenList(scores));
    }

    @Test
    public void testRandomGameWithLucky10() {
        RollProviderStub rollProviderStub = new RollProviderStub(10);
        Bowling project = new Bowling(rollProviderStub);

        int finalScore = 156;
        int [][] scores = {
            {10},
            {5,4},
            {10},
            {9,1},
            {10},
            {5,5},
            {0,0},
            {10},
            {4,5},
            {10,10,10},
        };

        assertEquals(finalScore, project.scoreWithGivenList(scores));
    }

    @Test
    public void testWithRollProviderStubPerfectScore() {
        RollProviderStub rollProviderStub = new RollProviderStub(10);
        ConsoleDisplayer mockDisplay = Mockito.mock(ConsoleDisplayer.class);
        Bowling project = new Bowling(rollProviderStub, mockDisplay);

        int finalScore = 300;

        assertEquals(finalScore, project.score());
    }

    @Test
    public void shouldCallDependency() {
        //given
        RollProviderStub rollProviderStub = new RollProviderStub(5);
        ConsoleDisplayer mockDisplay = Mockito.mock(ConsoleDisplayer.class);
        
        Bowling project = new Bowling(rollProviderStub, mockDisplay);

        // when
        project.score();
        
        // then
        BDDMockito.then(mockDisplay).should().displayScoreToConsole(150);
    }
}
