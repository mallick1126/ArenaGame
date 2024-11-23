package dev.program.Action;

import dev.program.Dice.Dice;
import dev.program.Player.Player;

public interface Action {
    void execute(Player attacker, Player defender, Dice dice);
}
