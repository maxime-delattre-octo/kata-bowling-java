package org.example;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class ProjectTest {

    @Test
    public void testNormal() {
        Project project = new Project();

        int finalScore = 29;
        //| 1, 1 | 5, 5 | 1, 1 | 1, 1 | 1, 1 | 1, 1 | 1, 1 | 1, 1 | 1, 1 | 1, 1 
        List<List<Integer>> scores = Arrays.asList(Arrays.asList(5,5 ), Arrays.asList(1,1 ), Arrays.asList(1,1 ), Arrays.asList(1,1 ), Arrays.asList(1,1 ),
        Arrays.asList(1,1 ), Arrays.asList(1,1 ), Arrays.asList(1,1 ), Arrays.asList(1,1 ), Arrays.asList(1,1 ));

        assertEquals(finalScore, project.score(scores));
    }

    @Test
    public void testSpare() {
        Project project = new Project();

        int finalScore = 29;
        //| 1, 1 | 5, 5 | 1, 1 | 1, 1 | 1, 1 | 1, 1 | 1, 1 | 1, 1 | 1, 1 | 1, 1 
        List<List<Integer>> scores = Arrays.asList(Arrays.asList(5,5 ), Arrays.asList(1,1 ), Arrays.asList(1,1 ), Arrays.asList(1,1 ), Arrays.asList(1,1 ),
        Arrays.asList(1,1 ), Arrays.asList(1,1 ), Arrays.asList(1,1 ), Arrays.asList(1,1 ), Arrays.asList(1,1 ));

        assertEquals(finalScore, project.score(scores));
    }

    @Test
    public void testStrike() {
        Project project = new Project();

        int finalScore = 30;
        //| 1, 1 | 10, 0 | 1, 1 | 1, 1 | 1, 1 | 1, 1 | 1, 1 | 1, 1 | 1, 1 | 1, 1 
        List<List<Integer>> scores = Arrays.asList(Arrays.asList(10, 0), Arrays.asList(1,1 ), Arrays.asList(1,1 ), Arrays.asList(1,1 ), Arrays.asList(1,1 ),
        Arrays.asList(1,1 ), Arrays.asList(1,1 ), Arrays.asList(1,1 ), Arrays.asList(1,1 ), Arrays.asList(1,1 ));

        assertEquals(finalScore, project.score(scores));
    }
}
