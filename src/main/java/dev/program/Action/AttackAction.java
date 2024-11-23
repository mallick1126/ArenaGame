package dev.program.Action;

import dev.program.Dice.Dice;
import dev.program.Player.Player;

public class AttackAction implements Action {
    @Override
    public void execute(Player attacker, Player defender, Dice dice) {
        int attackRoll = dice.roll();
        int defendRoll = dice.roll();
        int attackDamage = attacker.getAttack() * attackRoll;
        int defendStrength = defender.getStrength() * defendRoll;
        int damage = Math.max(0, attackDamage - defendStrength);
        defender.reduceHealth(damage);
        System.out.printf("%s attacks %s%n", attacker.getName(), defender.getName());
        System.out.printf("Attack Roll: %d, Defense Roll: %d%n", attackRoll, defendRoll);
        System.out.printf("Net Damage: %d, %s's remaining health: %d%n%n", damage, defender.getName(), defender.getHealth());
    }
}