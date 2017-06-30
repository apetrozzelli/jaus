package me.alessandropetrozzelli.jauscli;

import me.alessandropetrozzelli.jaus.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class CommandLineInterface {
    public static void main(String[] args) throws InvalidLocationException, LocationNotFreeException {
        System.out.println("Initializing jaus...");
        final List<Guest> guests = new ArrayList<>();

        Universe u = new Universe();
        WorldMap worldMap = new IdentityBasedMap();
        World w = new World(worldMap);
        u.addWorld("myWorld", w);
        Supplier<Guest> g = () -> {
            GuestImpl guest = new GuestImpl(GuestArrangementPolicy.getDefaultLocationSupplier(worldMap));
            guests.add(guest);
            return guest;
        };
        for (int i = 0; i < 10; i++) {
            w.addGuest(g);
        }

        for (Guest guest : guests) {
            guest.moveTo(GuestArrangementPolicy.getDefaultLocationSupplier(worldMap).get());
        }

    }

}
