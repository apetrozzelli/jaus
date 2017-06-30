package me.alessandropetrozzelli.jaus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UniverseTest {

    @Mock
    private World firstWorld;

    @Test
    public void anUniverseDefaultsToEmpty() {
        Universe sut = new Universe();
        assertNotNull(sut);

        assertTrue(sut.isEmpty());
    }

    @Test
    public void anUniverseCanHostAWorld() {
        Universe sut = new Universe();
        sut.addWorld("firstWorld", firstWorld);

        assertFalse(sut.isEmpty());
    }

}