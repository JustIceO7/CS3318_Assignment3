package org.example;

import java.util.HashSet;
import java.util.Set;

public class ColourTable {
    private final int[] colours;
    private final int capacity;
    private int current_index;
    private final Set<Integer> coloursTracker;

    public ColourTable(int capacity) {
        if (capacity <= 1) {
            throw new IllegalArgumentException("Capacity must be greater than 1.");
        }
        if (((capacity & (capacity - 1)) != 0)) {
            throw new IllegalArgumentException("Capacity must be a power of 2.");
        }
        this.colours = new int[capacity];
        this.capacity = capacity;
        this.current_index = 0;
        this.coloursTracker = new HashSet<>();
    }

    public void add(int r, int g, int b) {
        if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
            throw new IllegalArgumentException("Invalid RGB values.");
        }
        else if (this.current_index == this.capacity) {
            throw new ArrayIndexOutOfBoundsException("Too many colours added limit exceeded!");
        }
        int colour = (r << 16) | (g << 8) | b;
        if (this.coloursTracker.contains(colour)) {
            return;
        }
        this.colours[current_index] = colour;
        this.coloursTracker.add(colour);
        this.current_index++;
    }

    public void add(int colour) {
        if (colour < 0 || colour > 0xFFFFFF) {
            throw new IllegalArgumentException("Invalid RGB values.");
        }
        else if (this.current_index == this.capacity) {
            throw new ArrayIndexOutOfBoundsException("Too many colours added limit exceeded!");
        }
        else if (this.coloursTracker.contains(colour)) {
            return;
        }
        this.colours[current_index] = colour;
        this.coloursTracker.add(colour);
        this.current_index++;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int[] getColours() {
        return this.colours;
    }

    public int getCurrentIndex() {
        return this.current_index;
    }

    public Set<Integer> getColoursTracker() {
        return this.coloursTracker;
    }

}
