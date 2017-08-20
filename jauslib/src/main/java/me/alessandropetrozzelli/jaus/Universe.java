package me.alessandropetrozzelli.jaus;

import java.util.HashMap;

/**
 * This is the entry-point for JAUS system.
 * An {@link Universe} can host one (or more) {@link WorldImpl} identified by an unique name.
 */
public class Universe {

    private final HashMap<String, World> worlds = new HashMap<>();
    private final Clock clock;

    public Universe(Clock clock) {
        this.clock = clock;
    }

    public boolean addWorld(String name, World world) {
        if (worlds.containsKey(name))
            return false;

        worlds.putIfAbsent(name, world);

        return true;
    }

    boolean isEmpty() {
        return worlds.isEmpty();
    }
}
