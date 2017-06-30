package me.alessandropetrozzelli.jaus;

import java.util.function.Supplier;

public class GuestImpl implements Guest {
    private Location currentLocation;

    public GuestImpl(final Supplier<Location> initialLocation) {
        currentLocation = initialLocation.get();
    }

    public Location getLocation() {
        return currentLocation;
    }

    @Override
    public void moveTo(Location newLocation) throws InvalidLocationException {
        if (newLocation == null) {
            throw new InvalidLocationException(newLocation);
        }
        currentLocation = newLocation;
    }

}
