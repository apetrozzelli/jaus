package me.alessandropetrozzelli.jaus;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ConwayGameOfLifeWorldMapTest {

    @Mock
    private Location l;
    private WorldMap sut;
    @Mock
    private Guest g;

    @Before
    public void setup() {
        sut = new ConwayGameOfLifeWorldMap();
    }

    @Test
    public void aGameOfLifeStartsEmpty() {
        assertTrue(sut.isEmpty());
    }

    @Test
    public void aGameOfLifeCanHostAGuest() throws InvalidLocationException, LocationNotFreeException {
        assertTrue(sut.add(g));
        assertFalse(sut.isEmpty());
    }

    @Test
    public void aGameOfLifeCanNotHostAGuestTwice() throws InvalidLocationException, LocationNotFreeException {
        assertTrue(sut.add(g));
        assertFalse(sut.add(g));
    }

    @Test
    public void aGameOfLifeCanNotHostDistinctGuestAtTheSameLocation() throws InvalidLocationException, LocationNotFreeException {
        when(g.getLocation()).thenReturn(l);
        assertTrue(sut.add(g));

        Guest g2 = Mockito.mock(Guest.class);
        when(g2.getLocation()).thenReturn(l);
        assertFalse(sut.add(g2));
    }

    @Test
    public void aGameOfLifeCanReturnAStreamOfAllGuests() throws InvalidLocationException, LocationNotFreeException {
        assertTrue(sut.add(g));

        Guest g2 = Mockito.mock(Guest.class);
        final Location l2 = Mockito.mock(Location.class);
        when(g2.getLocation()).thenReturn(l2);
        assertTrue(sut.add(g2));

        Guest g3 = Mockito.mock(Guest.class);
        final Location l3 = Mockito.mock(Location.class);
        when(g3.getLocation()).thenReturn(l3);
        assertTrue(sut.add(g3));

        ConwayGameOfLifeWorldMap gol = (ConwayGameOfLifeWorldMap) sut;

        assertEquals(3, gol.getAllGuests().count());
    }

}
