package dev.program.Dice;

public class Dice {
    private final DiceStrategy diceStrategy;

    public Dice(DiceStrategy diceStrategy) {
        this.diceStrategy = diceStrategy;
    }

    public int roll() {
        return diceStrategy.roll();
    }
}
