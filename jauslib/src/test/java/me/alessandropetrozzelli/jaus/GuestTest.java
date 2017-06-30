package me.alessandropetrozzelli.jaus;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class GuestTest {
    private GuestImpl sut;

    @Mock
    private Location initialLocation = new Location();

    @Before
    public void setup() {
        sut = new GuestImpl(() -> initialLocation);
    }

    @Test
    public void aGuestHasALocation() {
        Location p = sut.getLocation();
        assertNotNull(p);
        assertEquals(initialLocation, p);
    }

    @Test(expected = InvalidLocationException.class)
    public void aGuestCanNotChangeItsLocationToNull() throws InvalidLocationException {
        sut.moveTo(null);
    }

    @Test
    public void aGuestCanChangeItsLocation() throws InvalidLocationException {
        Location newLocation = new Location();
        sut.moveTo(newLocation);
        assertEquals(newLocation, sut.getLocation());
    }
}