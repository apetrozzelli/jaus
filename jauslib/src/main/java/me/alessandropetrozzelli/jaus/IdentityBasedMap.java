package me.alessandropetrozzelli.jaus;

import java.util.HashSet;
import java.util.Set;

/**
 * The simplest {@link WorldMap} implementation as it just refuses a {@link Guest} with a null {@link Location}
 * or whose {@link Location} is not free.
 */
public class IdentityBasedMap implements WorldMap {

    private final Set<Guest> guests = new HashSet<>();

    @Override
    public boolean isEmpty() {
        return guests.isEmpty();
    }

    boolean checkLocationIsFree(final Location l) {
        if (isEmpty()) {
            return true;
        }
        return guests.stream().noneMatch((guest -> guest.getLocation().equals(l)));
    }

    @Override
    public boolean add(Guest guest) throws InvalidLocationException, LocationNotFreeException {
        Location l = guest.getLocation();
        if (l == null) {
            throw new InvalidLocationException(l);
        }
        if (!checkLocationIsFree(l)) {
            throw new LocationNotFreeException(l);
        }

        return guests.add(guest);
    }
}
