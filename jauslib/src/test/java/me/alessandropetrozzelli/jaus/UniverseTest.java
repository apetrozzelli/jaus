package me.alessandropetrozzelli.jaus;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UniverseTest {

    private Universe sut;

    @Mock
    private Guest aGuest;
    @Mock
    private Location aLocation;
    @Mock
    private Guest anotherGuest;
    @Mock
    private Location anotherLocation;

    @Before
    public void setUp() throws Exception {
        sut = new Universe();
        when(aGuest.getLocation()).thenReturn(aLocation);
        when(anotherGuest.getLocation()).thenReturn(anotherLocation);
    }

    @Test
    public void anUniverseDefaultsToEmpty() {
        assertTrue(sut.isEmpty());
    }

    @Test
    public void anUniverseRejectsNullGuests() throws UniverseException {
        assertFalse(sut.addGuest(() -> null));
    }

    @Test
    public void anUniverseCanHostAGuest() throws UniverseException {
        assertTrue(sut.addGuest(() -> aGuest));
    }

    @Test
    public void anUniverseIsNotEmptyOnceAGuestHasBeenAdded() throws UniverseException {
        assertTrue(sut.addGuest(() -> aGuest));
        assertFalse(sut.isEmpty());
    }

    @Test
    public void anUniverseCanHostDistinctGuests() throws UniverseException {
        assertTrue(sut.addGuest(() -> aGuest));
        assertTrue(sut.addGuest(() -> anotherGuest));
        assertTrue(sut.addGuest(() -> new GuestImpl(new Location())));
    }

    @Test(expected = LocationNotFreeException.class)
    public void aGuestLocationMustBeUnique() throws UniverseException {
        Location l = new Location();
        when(aGuest.getLocation()).thenReturn(l);
        sut.addGuest(() -> aGuest);
        when(anotherGuest.getLocation()).thenReturn(l);
        sut.addGuest(() -> anotherGuest);
    }

}