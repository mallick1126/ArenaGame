package dev.program.Arena;

import dev.program.Action.Action;
import dev.program.Dice.Dice;
import dev.program.Dice.SixSidedDiceStrategy;
import dev.program.Player.Player;

public class Arena {
    private static Arena instance;
    private final Dice dice;

    private Arena() {
        this.dice = new Dice(new SixSidedDiceStrategy());
    }

    public static Arena getInstance() {
        if (instance == null) {
            instance = new Arena();
        }
        return instance;
    }

    public Player fight(Player player1, Player player2, Action action) {
        if (player1 == null || player2 == null) {
            throw new IllegalArgumentException("Both players must be non-null");
        }

        Player attacker = player1.getHealth() <= player2.getHealth() ? player1 : player2;
        Player defender = attacker == player1 ? player2 : player1;

        while (player1.isAlive() && player2.isAlive()) {
            action.execute(attacker, defender, dice);

            // Swap roles
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        return player1.isAlive() ? player1 : player2;
    }
}
