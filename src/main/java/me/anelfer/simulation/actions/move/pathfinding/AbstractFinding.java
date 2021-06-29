package me.anelfer.simulation.actions.move.pathfinding;

import javafx.util.Pair;
import lombok.val;
import me.anelfer.simulation.entities.сreature.AbstractCreature;
import me.anelfer.simulation.map.MapLocation;
import me.anelfer.simulation.map.MapSimulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public abstract class AbstractFinding {

    protected final MapSimulation map;
    protected final HashMap<MapLocation, List<MapLocation>> graph = new HashMap<>();
    protected final AbstractCreature entity;
    protected final HashMap<MapLocation, MapLocation> visited = new HashMap<>();
    protected MapLocation curNode;

    public AbstractFinding(MapSimulation map, AbstractCreature entity) {
        this.map = map;
        this.entity = entity;
    }

    public abstract void finding();

    public MapLocation getDestination() {
        for (MapLocation location : map.keySet()) {
            List<MapLocation> locList = new ArrayList<>(getNextNode(location.getX(), location.getY()));
            graph.put(location, locList);
        }

        finding();

        MapLocation pathSegment = curNode;
        List<MapLocation> path = new ArrayList<>();

        while (pathSegment != null) {
            path.add(pathSegment);
            pathSegment = visited.get(pathSegment);
        }

        Collections.reverse(path);

        if (path.size() - 1 >= (entity.getSpeed())) {
            return path.get(entity.getSpeed());
        } else {
            return path.get(0);
        }

    }

    public List<MapLocation> getNextNode(int x, int y) {
        List<Pair<Integer, Integer>> ways = new ArrayList<>();

        ways.add(new Pair<>(-1, 0));
        ways.add(new Pair<>(0, -1));
        ways.add(new Pair<>(1, 0));
        ways.add(new Pair<>(0, 1));

        val list = new ArrayList<MapLocation>();

        ways.forEach((pair) -> {
            int dx = pair.getKey();
            int dy = pair.getValue();

            if (checkNextNode(x + dx, y + dy)) {
                list.add(new MapLocation(x + dx, y + dy));
            }
        });
        return list;
    }

    private Boolean checkNextNode(int x, int y) {
        if (0 <= x && x < map.getX() && 0 <= y && y < map.getY()) {
            return entity.getPreys().contains(map.getSimulationEntity(x, y).getType()) || map.isCellEmpty(x, y)
                    && entity.getType() != map.getSimulationEntity(x, y).getType();
        } else {
            return false;
        }
    }

}
