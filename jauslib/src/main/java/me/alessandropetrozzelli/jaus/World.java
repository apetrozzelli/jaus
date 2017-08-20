package me.alessandropetrozzelli.jaus;

import java.util.function.Supplier;

/**
 * A {@link World} deals with {@link Guest} as it can host them.
 */
public interface World {

    void addGuests(Supplier<Guest> g, int numberOfGuests) throws LocationNotFreeException, InvalidLocationException;

    boolean addGuest(Supplier<Guest> g) throws LocationNotFreeException, InvalidLocationException;
}
