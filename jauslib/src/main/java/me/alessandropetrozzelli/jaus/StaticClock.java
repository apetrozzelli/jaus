package me.alessandropetrozzelli.jaus;

/**
 * The simplest {@link Clock} as it reports always the same time and is not able to {@link #tick()} properly.
 */
public class StaticClock implements Clock {
    @Override
    public int getCurrentTime() {
        return 0;
    }

    @Override
    public void tick() {

    }
}
