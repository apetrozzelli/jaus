package me.alessandropetrozzelli.jaus;

/**
 * Simple time-related concept. A {@link Clock} is able to what time is it {@link #getCurrentTime()} and can be told
 * to advance to the next time unit.
 */
public interface Clock {
    int getCurrentTime();

    void tick();
}
