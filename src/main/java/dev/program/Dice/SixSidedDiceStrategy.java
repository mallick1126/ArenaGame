package dev.program.Dice;

import java.util.Random;

public class SixSidedDiceStrategy implements DiceStrategy {
    private final Random random = new Random();

    @Override
    public int roll() {
        return random.nextInt(6) + 1;
    }
}
