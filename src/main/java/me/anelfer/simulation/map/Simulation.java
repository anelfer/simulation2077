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
import me.anelfer.simulation.actions.starve.PredatorStarveAction;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

public class Simulation {

    @Getter
    public static final int Y = 35;
    @Getter
    public static final int X = 35;
    @Getter
    private static int moveCounter = 0;
    @Getter
    private final MapSimulation map = new MapSimulation(X, Y);
    private final ArrayList<AbstractAction> actions = new ArrayList<>();
    private final ArrayList<AbstractAction> initActions = new ArrayList<>();
    @Getter
    private static final Properties property = new Properties();

    public Simulation() {
        initActions.add(new RockSpawnAction(10, map));
        initActions.add(new TreeSpawnAction(10, map));
        initActions.add(new PredatorSpawnAction(5, map));
        initActions.add(new HerbivoreSpawnAction(10, map));

        actions.add(new GrassSpawnAction(10, map));
        actions.add(new EmptyFillerAction(map));

        actions.add(new PredatorStarveAction(map));

        actions.add(new PredatorMoveAction(map));
        actions.add(new HerbivoreMoveAction(map));


        InputStream fis;
        try {
            fis = getClass().getClassLoader().getResourceAsStream("config.properties");
            property.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void nextTurn() {

        if (moveCounter < 1) {
            for (AbstractAction initAction : initActions) {
                initAction.perform();
            }
        }

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
