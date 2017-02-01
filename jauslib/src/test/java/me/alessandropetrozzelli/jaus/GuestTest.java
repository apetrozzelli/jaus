package me.alessandropetrozzelli.jaus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class GuestTest {

    @Test
    public void aGuestHasALocation() {
        GuestImpl sut = new GuestImpl(() -> new Location());
        Location p = sut.getLocation();
        assertNotNull(p);
    }
}