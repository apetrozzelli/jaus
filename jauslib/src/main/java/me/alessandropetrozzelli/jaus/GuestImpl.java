package me.alessandropetrozzelli.jaus;

import java.util.function.Supplier;

class GuestImpl implements Guest {
    private Location location;
    private Location currentLocation;

    GuestImpl(final Supplier<Location> initialLocation) {
        currentLocation = initialLocation.get();
    }

    public Location getLocation() {
        return currentLocation;
    }

}
