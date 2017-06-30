package me.alessandropetrozzelli.jaus;

public interface Guest {
    Location getLocation();

    void moveTo(Location newLocation) throws InvalidLocationException;
}
