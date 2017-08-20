package me.alessandropetrozzelli.jaus;

import java.util.function.Supplier;

/**
 * A specific {@link World} which delegates to a {@link WorldMap} to host a {@link Guest} to its {@link Location}.
 */
public class WorldImpl implements World {

    private final WorldMap map;

    public WorldImpl(WorldMap map) {
        this.map = map;
    }

    @Override
    public void addGuests(final Supplier<Guest> g, final int numberOfGuests) throws LocationNotFreeException, InvalidLocationException {
        for (int i = 0; i < numberOfGuests; i++) {
            addGuest(g);
        }
    }

    boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean addGuest(final Supplier<Guest> g) throws LocationNotFreeException, InvalidLocationException {
        if (g == null) {
            return false;
        }
        Guest guest = g.get();
        if (guest == null) {
            return false;
        }
        return map.add(g.get());
    }

}
