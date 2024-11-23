package dev.program;

import dev.program.Action.Action;
import dev.program.Action.AttackAction;
import dev.program.Arena.Arena;
import dev.program.Player.Player;

public class Main {
    public static void main(String[] args) {
        Player playerA = new Player.Builder("Player A")
                .health(150)
                .strength(20)
                .attack(15)
                .build();

        Player playerB = new Player.Builder("Player B")
                .health(100)
                .strength(10)
                .attack(25)
                .build();


        Arena arena = Arena.getInstance();
        Action attackAction = new AttackAction();
        Player winner = arena.fight(playerA, playerB, attackAction);

        System.out.println("Winner: " + winner.getName());
    }
}