package me.alessandropetrozzelli.jaus;

import java.util.function.Supplier;

class World {

    private final WorldMap map;

    World(WorldMap map) {
        this.map = map;
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean addGuest(final Supplier<Guest> aGuest) throws LocationNotFreeException, InvalidLocationException {
        if (aGuest == null) {
            return false;
        }
        Guest g = aGuest.get();
        if (g == null) {
            return false;
        }
        return map.add(aGuest.get());
    }

}
