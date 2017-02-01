package me.alessandropetrozzelli.jaus;

public interface WorldMap {

    boolean isEmpty();

    boolean add(Guest guest) throws InvalidLocationException, LocationNotFreeException;
}
