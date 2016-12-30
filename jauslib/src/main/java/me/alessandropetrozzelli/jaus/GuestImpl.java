package me.alessandropetrozzelli.jaus;

class GuestImpl implements Guest {
    private Location location;
    private Location currentLocation;

    GuestImpl(Location initialLocation) {

        currentLocation = initialLocation;
    }

    public Location getLocation() {
        return currentLocation;
    }

}
