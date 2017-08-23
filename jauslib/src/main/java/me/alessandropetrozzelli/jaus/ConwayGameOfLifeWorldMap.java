package me.alessandropetrozzelli.jaus;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ConwayGameOfLifeWorldMap implements WorldMap {

    private Map<Location, Guest> guests = new HashMap<>();

    @Override
    public boolean isEmpty() {
        return guests.isEmpty();
    }

    @Override
    public boolean add(Guest guest) throws InvalidLocationException, LocationNotFreeException {
        if (guests.containsKey(guest.getLocation())) {
            return false;
        }
        guests.put(guest.getLocation(), guest);
        return true;
    }

    Stream<Map.Entry<Location, Guest>> getAllGuests() {
        return guests.entrySet().stream();
    }
}
