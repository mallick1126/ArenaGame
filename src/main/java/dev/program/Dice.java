package dev.program;

import java.util.Random;

public class Dice {
    private final int sides;
    private final Random random;

    public Dice(int sides) {
        if (sides < 1) {
            throw new IllegalArgumentException("Dice must have at least 1 side");
        }
        this.sides = sides;
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(sides) + 1;
    }
}
