package me.alessandropetrozzelli.jaus;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

class Universe {
    private final Set<Guest> guests = new HashSet<>();

    public boolean isEmpty() {
        return guests.isEmpty();
    }

    public boolean addGuest(final Supplier<Guest> aGuest) throws LocationNotFreeException, InvalidLocationException {
        if (aGuest == null) {
            return false;
        }
        Guest g = aGuest.get();
        if (g == null) {
            return false;
        }
        Location l = g.getLocation();
        if (l == null) {
            throw new InvalidLocationException(l);
        }
        if (!checkLocationIsFree(l)) {
            throw new LocationNotFreeException(l);
        }
        return guests.add(aGuest.get());
    }

    private boolean checkLocationIsFree(final Location l) {
        if (isEmpty()) {
            return true;
        }
        return guests.stream().noneMatch((guest -> guest.getLocation().equals(l)));
    }
}
