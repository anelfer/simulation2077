package me.anelfer.simulation.entities.сreature;

import lombok.Getter;

@Getter
public class HP {

    private final int max;
    private int current;

    public HP(int max) {
        this.max = max;
        this.current = max;
    }

    public void takeDamage(int damage) {
        current -= damage;
        if (current < 0) current = 0;
    }

    public void heal(int addHealth) {
        current += addHealth;
        if (current > max) current = max;
    }

}
