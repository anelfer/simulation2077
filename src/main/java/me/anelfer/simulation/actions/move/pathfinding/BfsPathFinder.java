package me.anelfer.simulation.actions.move.pathfinding;

import me.anelfer.simulation.entities.сreature.AbstractCreature;
import me.anelfer.simulation.map.MapLocation;
import me.anelfer.simulation.map.MapSimulation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class BfsPathFinder extends AbstractFinding {

    public BfsPathFinder(MapSimulation map, AbstractCreature entity) {
        super(map, entity);
    }

    @Override
    public void finding() {
        MapLocation location = entity.getLocation();
        Deque<MapLocation> deque = new ArrayDeque<>();

        deque.add(location);
        visited.put(location, null);

        while (!deque.isEmpty()) {
            curNode = deque.pollFirst();

            if (entity.getPreys().contains(map.getSimulationEntity(curNode).getType())) {
                break;
            }

            List<MapLocation> nextNodes = graph.get(curNode);

            for (MapLocation node : nextNodes) {
                if (!visited.containsKey(node)) {
                    deque.add(node);
                    visited.put(node, curNode);
                }
            }
        }
    }

}
