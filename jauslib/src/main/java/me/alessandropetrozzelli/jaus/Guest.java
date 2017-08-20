package me.alessandropetrozzelli.jaus;

/**
 * The reason for an {@link Universe} to exist, to host a {@link Guest}.
 * A {@link Guest} is location-aware and can move toward another {@link Location} when asked through {@link #moveTo(Location)}.
 */
public interface Guest {
    Location getLocation();

    void moveTo(Location newLocation) throws InvalidLocationException;
}
