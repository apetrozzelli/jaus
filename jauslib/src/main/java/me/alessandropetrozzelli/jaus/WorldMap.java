package me.alessandropetrozzelli.jaus;

/**
 * A {@link WorldMap} represents the geometric aspect of a {@link WorldImpl}.
 * The {@link WorldMap} keeps track of the valid and allowed {@link Location} within the {@link WorldImpl}.
 */
public interface WorldMap {

    boolean isEmpty();

    boolean add(Guest guest) throws InvalidLocationException, LocationNotFreeException;
}
