package me.alessandropetrozzelli.jaus;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WorldImplTest {

    private WorldImpl sut;

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
        sut = new WorldImpl(new IdentityBasedMap());
        when(aGuest.getLocation()).thenReturn(aLocation);
        when(anotherGuest.getLocation()).thenReturn(anotherLocation);
    }

    @Test
    public void aWorldDefaultsToEmpty() {
        assertTrue(sut.isEmpty());
    }

    @Test
    public void aWorldRejectsNullGuests() throws UniverseException {
        assertFalse(sut.addGuest(() -> null));
    }

    @Test
    public void aWorldCanHostAGuest() throws UniverseException {
        assertTrue(sut.addGuest(() -> aGuest));
    }

    @Test
    public void aWorldIsNotEmptyOnceAGuestHasBeenAdded() throws UniverseException {
        assertTrue(sut.addGuest(() -> aGuest));
        assertFalse(sut.isEmpty());
    }

    @Test
    public void aWorldCanHostDistinctGuests() throws UniverseException {
        assertTrue(sut.addGuest(() -> aGuest));
        assertTrue(sut.addGuest(() -> anotherGuest));
        assertTrue(sut.addGuest(() -> new GuestImpl(() -> new Location())));
    }

    @Test(expected = LocationNotFreeException.class)
    public void aGuestLocationMustBeUniqueWithinAWorld() throws UniverseException {
        Location l = new Location();
        when(aGuest.getLocation()).thenReturn(l);
        sut.addGuest(() -> aGuest);
        when(anotherGuest.getLocation()).thenReturn(l);
        sut.addGuest(() -> anotherGuest);
    }

}