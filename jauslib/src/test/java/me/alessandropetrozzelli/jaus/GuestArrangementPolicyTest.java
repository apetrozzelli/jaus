package me.alessandropetrozzelli.jaus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class GuestArrangementPolicyTest {

    @Mock
    WorldMap world;

    @Test
    public void defaultPolicyExists() {
        GuestArrangementPolicy sut = GuestArrangementPolicy.defaultArrangementPolicyFor(world);
        assertNotNull(sut);
    }

}