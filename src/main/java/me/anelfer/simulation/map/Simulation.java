package me.anelfer.simulation.map;

import lombok.Getter;
import me.anelfer.simulation.actions.AbstractAction;
import me.anelfer.simulation.actions.move.HerbivoreMoveAction;
import me.anelfer.simulation.actions.move.PredatorMoveAction;
import me.anelfer.simulation.actions.spawn.AbstractSpawnAction;
import me.anelfer.simulation.actions.spawn.creature.GrassSpawnAction;
import me.anelfer.simulation.actions.spawn.creature.HerbivoreSpawnAction;
import me.anelfer.simulation.actions.spawn.creature.PredatorSpawnAction;
import me.anelfer.simulation.actions.spawn.object.EmptyFillerAction;
import me.anelfer.simulation.actions.spawn.object.RockSpawnAction;
import me.anelfer.simulation.actions.spawn.object.TreeSpawnAction;

import java.util.ArrayList;
import java.util.Random;

public class Simulation {

    @Getter
    public static final int Y = 35;
    @Getter
    public static final int X = 35;
    public MapSimulation map = new MapSimulation(X, Y);
    private final ArrayList<AbstractAction> actions = new ArrayList<>();
    @Getter
    private static int moveCounter = 0;

    public Simulation() {
        actions.add(new RockSpawnAction(10, map));
        actions.add(new GrassSpawnAction(10, map));
        actions.add(new TreeSpawnAction(10, map));

        actions.add(new PredatorSpawnAction(5, map));
        actions.add(new HerbivoreSpawnAction(10, map));

        actions.add(new EmptyFillerAction(map));

        actions.add(new PredatorMoveAction(map));
        actions.add(new HerbivoreMoveAction(map));
    }

    public void nextTurn() {
        for (AbstractAction action : actions) {
            action.perform();
        }
        moveCounter++;
        System.out.println("Step: " + moveCounter);
    }

    public void reset() {
        moveCounter = 0;
        map.clear();
        AbstractSpawnAction.setRandom(new Random(AbstractSpawnAction.getSeed()));
    }

}
