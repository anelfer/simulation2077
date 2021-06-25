package me.anelfer.simulation.map;

import lombok.Getter;
import me.anelfer.simulation.actions.AbstractAction;
import me.anelfer.simulation.actions.move.HerbivoreMoveAction;
import me.anelfer.simulation.actions.move.PredatorMoveAction;
import me.anelfer.simulation.actions.spawn.creature.HerbivoreSpawnAction;
import me.anelfer.simulation.actions.spawn.creature.PredatorSpawnAction;
import me.anelfer.simulation.actions.spawn.object.EntitySpawnAction;
import me.anelfer.simulation.actions.spawn.creature.GrassSpawnAction;
import me.anelfer.simulation.actions.spawn.object.RockSpawnAction;
import me.anelfer.simulation.actions.spawn.object.TreeSpawnAction;

import java.util.ArrayList;

public class Simulation {

    @Getter
    public static final int Y = 35;
    @Getter
    public static final int X = 35;
    public MapSimulation map = new MapSimulation(X, Y);
    private final ArrayList<AbstractAction> actions = new ArrayList<>();
    @Getter
    private static int counter = 0;

    public Simulation() {
        actions.add(new RockSpawnAction(10, map));
        actions.add(new GrassSpawnAction(10, map));
        actions.add(new TreeSpawnAction(10, map));

        actions.add(new PredatorSpawnAction(5, map));
        actions.add(new HerbivoreSpawnAction(10, map));

        actions.add(new EntitySpawnAction(map));

        actions.add(new PredatorMoveAction(map));
        actions.add(new HerbivoreMoveAction(map));
    }

    public void start() {
        for (AbstractAction action : actions) {
            action.perform();
        }
        counter++;
        System.out.println("Step: " + counter);
    }

    public void reset() {
        counter = 0;
        map.clear();
        map.resetEntityCount();
    }

}
