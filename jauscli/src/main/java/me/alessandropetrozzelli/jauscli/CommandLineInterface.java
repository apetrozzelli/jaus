package me.alessandropetrozzelli.jauscli;

import me.alessandropetrozzelli.jaus.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class CommandLineInterface {
    public static void main(String[] args) throws InvalidLocationException, LocationNotFreeException {
        System.out.println("Initializing jaus...");

        Universe u = new Universe(new StaticClock());
        WorldMap worldMap = new IdentityBasedMap();
        WorldImpl w = new WorldImpl(worldMap);
        u.addWorld("myWorld", w);

        final List<Guest> guests = new ArrayList<>();
        Supplier<Guest> g = () -> {
            GuestImpl guest = new GuestImpl(GuestArrangementPolicy.getDefaultLocationSupplier(worldMap));
            guests.add(guest);
            return guest;
        };

        int numberOfGuests = 10;
        w.addGuests(g, numberOfGuests);

        for (Guest guest : guests) {
            guest.moveTo(GuestArrangementPolicy.getDefaultLocationSupplier(worldMap).get());
        }

    }

}
