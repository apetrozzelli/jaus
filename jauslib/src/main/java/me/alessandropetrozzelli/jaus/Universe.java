package me.alessandropetrozzelli.jaus;

import java.util.HashMap;

public class Universe {

    private final HashMap<String, World> worlds = new HashMap();

    boolean addWorld(String name, World world) {
        if (worlds.containsKey(name))
            return false;

        worlds.putIfAbsent(name, world);

        return true;
    }
}
