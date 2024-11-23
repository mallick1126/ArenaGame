package dev.program;

public class Arena {
    private final Dice dice;

    public Arena() {
        this.dice = new Dice(6);
    }

    public Player fight(Player player1, Player player2) {
        if (player1 == null || player2 == null) {
            throw new IllegalArgumentException("Both players must be non-null");
        }

        Player attacker = player1.getHealth() <= player2.getHealth() ? player1 : player2;
        Player defender = attacker == player1 ? player2 : player1;

        while (player1.isAlive() && player2.isAlive()) {
            processTurn(attacker, defender);

            // Swap roles
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        return player1.isAlive() ? player1 : player2;
    }

    private void processTurn(Player attacker, Player defender) {
        int attackRoll = dice.roll();
        int defendRoll = dice.roll();

        int attackDamage = attacker.getAttack() * attackRoll;
        int defendStrength = defender.getStrength() * defendRoll;

        int damage = Math.max(0, attackDamage - defendStrength);
        defender.reduceHealth(damage);

        System.out.printf("%s attacks %s%n", attacker.getName(), defender.getName());
        System.out.printf("Attack Roll: %d, Defense Roll: %d%n", attackRoll, defendRoll);
        System.out.printf("Attack Damage: %d, Defense Strength: %d%n", attackDamage, defendStrength);
        System.out.printf("Net Damage: %d, %s's remaining health: %d%n%n",
                damage, defender.getName(), defender.getHealth());
    }
}
