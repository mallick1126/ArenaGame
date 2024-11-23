package dev.program.Player;

public class Player {
    private final String name;
    private int health;
    private final int strength;
    private final int attack;

    private Player(Builder builder) {
        this.name = builder.name;
        this.health = builder.health;
        this.strength = builder.strength;
        this.attack = builder.attack;
    }

    public static class Builder {
        private String name;
        private int health;
        private int strength;
        private int attack;

        public Builder(String name) {
            this.name = name;
        }

        public Builder health(int health) {
            if (health <= 0) throw new IllegalArgumentException("Health must be positive");
            this.health = health;
            return this;
        }

        public Builder strength(int strength) {
            if (strength <= 0) throw new IllegalArgumentException("Strength must be positive");
            this.strength = strength;
            return this;
        }

        public Builder attack(int attack) {
            if (attack <= 0) throw new IllegalArgumentException("Attack must be positive");
            this.attack = attack;
            return this;
        }

        public Player build() {
            return new Player(this);
        }
    }
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAttack() {
        return attack;
    }

    public void reduceHealth(int damage) {
        this.health = Math.max(0, this.health - damage);
    }

    public boolean isAlive() {
        return health > 0;
    }
}
