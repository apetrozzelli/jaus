package me.alessandropetrozzelli.jaus;

import java.util.HashSet;
import java.util.Set;

class Universe {
    private final Set<Guest> guests = new HashSet<>();

    public boolean isEmpty() {
        return guests.isEmpty();
    }

    public boolean addGuest(Guest aGuest) {
        if (aGuest == null) {
            return false;
        }
        return guests.add(aGuest);
    }
}
