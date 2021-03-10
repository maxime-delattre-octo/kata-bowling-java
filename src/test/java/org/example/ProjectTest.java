package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class ProjectTest {

    @Test
    public void testNormalStartGame() {
        Project project = new Project();
        project.setCurrentScore(0);

        int score = project.getScore();

        int l1 = 2;
        int l2 = 3;

        int frameScore = score + l1+l2;

        assertEquals(frameScore, project.score(l1+l2));
    }

    @Test
    public void testSpare() {
        Project project = new Project();

        int score = 10;
        int l1 = 5;

        score = score+l1;
        assertEquals(score, project.score(l1,l2));
    }

    @Test
    public void testStrike() {
        Project project = new Project();
        int s1 = 10;
        int s2 = 0;

        int score = (s1+s2)*2;

        assertEquals(score, project.score(s1,s2));
    }
}
