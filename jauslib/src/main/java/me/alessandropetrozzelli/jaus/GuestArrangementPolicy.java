package me.alessandropetrozzelli.jaus;

import java.util.function.Supplier;

public interface GuestArrangementPolicy {

    static GuestArrangementPolicy defaultArrangementPolicyFor(WorldMap map) {
        return new GuestArrangementPolicy() {

            @Override
            public Location getLocation() {
                return new Location();
            }
        };
    }

    static Supplier<Location> getDefaultLocationSupplier(WorldMap worldMap) {
        return () -> defaultArrangementPolicyFor(worldMap).getLocation();
    }

    Location getLocation();

}
