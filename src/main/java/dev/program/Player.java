package dev.program;

public class Player {
    private final String name;
    private int health;
    private final int strength;
    private final int attack;

    public Player(String name, int health, int strength, int attack) {
        if (health <= 0 || strength <= 0 || attack <= 0) {
            throw new IllegalArgumentException("All attributes must be positive");
        }
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
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
