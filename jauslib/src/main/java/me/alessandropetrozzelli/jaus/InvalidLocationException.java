package me.alessandropetrozzelli.jaus;

public class InvalidLocationException extends UniverseException {
    private final Location invalidLocation;

    InvalidLocationException(Location invalidLocation) {
        this.invalidLocation = invalidLocation;
    }
}
