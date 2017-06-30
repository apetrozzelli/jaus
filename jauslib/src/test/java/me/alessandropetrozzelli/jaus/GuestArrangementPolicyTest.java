package me.alessandropetrozzelli.jaus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class GuestArrangementPolicyTest {

    @Mock
    private WorldMap world;

    @Test
    public void defaultPolicyExists() {
        GuestArrangementPolicy sut = GuestArrangementPolicy.defaultArrangementPolicyFor(world);
        assertNotNull(sut);
    }

}