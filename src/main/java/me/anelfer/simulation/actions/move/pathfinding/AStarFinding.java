package me.anelfer.simulation.actions.move.pathfinding;

import me.anelfer.simulation.entities.сreature.AbstractCreature;
import me.anelfer.simulation.map.MapLocation;
import me.anelfer.simulation.map.MapSimulation;

import java.util.PriorityQueue;
import java.util.Queue;


public class AStarFinding extends AbstractFinding {

    public AStarFinding(MapSimulation map, AbstractCreature entity) {
        super(map, entity);
    }

    @Override
    public void finding() {
        MapLocation location = entity.getLocation();
        Queue<MapLocation> queue = new PriorityQueue<>();

        queue.add(location);
        visited.put(location, null);


    }

}
