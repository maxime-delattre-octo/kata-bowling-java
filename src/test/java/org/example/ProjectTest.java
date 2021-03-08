package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class ProjectTest {

    @Test
    public void testAssertion() {
        Dependency dependency = new Dependency();
        Project project = new Project(dependency);

        assertEquals(1, project.testFunction());
    }

    @Test
    public void testMock() {
        Dependency mockDependency = mock(Dependency.class);
        Project project = new Project(mockDependency);

        project.testFunction();

        verify(mockDependency).mockFunction();
    }

    @Test
    public void testStub() {
        Dependency mockDependency = mock(Dependency.class);
        Project project = new Project(mockDependency);
        when(mockDependency.stubFunction()).thenReturn(15);

        assertEquals(15, project.testFunction());
    }
}
