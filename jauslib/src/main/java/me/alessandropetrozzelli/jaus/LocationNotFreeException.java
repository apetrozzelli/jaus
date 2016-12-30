package me.alessandropetrozzelli.jaus;

public class LocationNotFreeException extends UniverseException {
    private final Location invalidLocation;

    LocationNotFreeException(Location l) {
        invalidLocation = l;
    }
}
