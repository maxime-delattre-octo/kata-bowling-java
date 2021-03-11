package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProjectTest {

    @Test
    public void testNormal() {
        Project project = new Project();

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
        assertEquals(finalScore, project.score(scores));
    }

    @Test
    public void testSpare() {
        Project project = new Project();

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
        assertEquals(finalScore, project.score(scores));
    }

    @Test
    public void testSpareTwice() {
        Project project = new Project();

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
        assertEquals(finalScore, project.score(scores));
    }

    @Test
    public void testStrike() {
        Project project = new Project();

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
        assertEquals(finalScore, project.score(scores));
    }

    @Test
    public void testStrikeTwice() {
        Project project = new Project();

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
        assertEquals(finalScore, project.score(scores));
    }

    @Test
    public void testRandomGame() {
        Project project = new Project();

        int finalScore = 128;
        //| 10 | 5,4 | 10 | 9, 1 | 10 | 5, 5 | 0, 0 | 10 | 4, 5 | 1, 1 

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

        assertEquals(finalScore, project.score(scores));
    }

    @Test
    public void testRandomGameWithLucky10() {
        Project project = new Project();

        
        int finalScore = 156;
        //| 10 | 5,4 | 10 | 9, 1 | 10 | 5, 5 | 0, 0 | 10 | 4, 5 | 10,10,10
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

        assertEquals(finalScore, project.score(scores));
    }
}
