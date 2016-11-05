package me.alessandropetrozzelli.jaus;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class UniverseTest {

    private Universe sut;

    @Mock
    private Guest aGuest;

    @Before
    public void setUp() throws Exception {
        sut = new Universe();
    }

    @Test
    public void anUniverseDefaultsToEmpty() {
        assertTrue(sut.isEmpty());
    }

    @Test
    public void anUniverseRejectsNullGuests() {
        assertFalse(sut.addGuest(null));
    }

    @Test
    public void anUniverseCanHostAGuest() {
        assertTrue(sut.addGuest(aGuest));
    }

    @Test
    public void anUniverseIsNotEmptyOnceAGuestHasBeenAdded() {
        assertTrue(sut.addGuest(aGuest));
        assertFalse(sut.isEmpty());
    }

    @Test
    public void anUniverseCanNotHostAGuestMoreThanOnce() {
        assertTrue(sut.addGuest(aGuest));
        assertFalse(sut.addGuest(aGuest));
    }

    @Test
    public void anUniverseCanHostDistinctGuests() {
        assertTrue(sut.addGuest(aGuest));
        assertTrue(sut.addGuest(new Guest()));
        assertTrue(sut.addGuest(new Guest()));
    }

}