package dev.program.Player;

public class PlayerBuilder {
    private  String name;
    private  int health;
    private  int strength;
    private  int attack;

    public PlayerBuilder(){}

    public PlayerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PlayerBuilder health(int health) {
        if (health <= 0) throw new IllegalArgumentException("Health must be positive");
        this.health = health;
        return this;
    }

    public PlayerBuilder strength(int strength) {
        if (strength <= 0) throw new IllegalArgumentException("Strength must be positive");
        this.strength = strength;
        return this;
    }

    public PlayerBuilder attack(int attack) {
        if (attack <= 0) throw new IllegalArgumentException("Attack must be positive");
        this.attack = attack;
        return this;
    }


    public Player build() {
        return new Player(name, health, strength, attack);
    }


}
