package me.anelfer.simulation.entities;

import lombok.Getter;

public abstract class SimulationEntity {

    @Getter
    private final String name;

    public SimulationEntity(String name) {
        this.name = name;
    }

}
