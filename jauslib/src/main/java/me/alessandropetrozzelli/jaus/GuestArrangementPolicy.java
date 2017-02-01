package me.alessandropetrozzelli.jaus;

public interface GuestArrangementPolicy {

    static GuestArrangementPolicy defaultArrangementPolicyFor(WorldMap map) {
        return new GuestArrangementPolicy() {

            @Override
            public Location getLocation() {
                return new Location();
            }
        };
    }

    Location getLocation();

}
