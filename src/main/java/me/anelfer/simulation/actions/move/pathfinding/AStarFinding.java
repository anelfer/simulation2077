package me.anelfer.simulation.actions.move.pathfinding;

import javafx.util.Pair;
import lombok.val;
import me.anelfer.simulation.entities.object.EmptyEntity;
import me.anelfer.simulation.entities.сreature.AbstractCreature;
import me.anelfer.simulation.map.MapLocation;
import me.anelfer.simulation.map.MapSimulation;

import java.util.*;

//BSF
public class AStarFinding {

    private final MapSimulation map;
    private final HashMap<MapLocation, List<MapLocation>> graph = new HashMap<>();
    private final AbstractCreature entity;

    private final HashMap<MapLocation, MapLocation> visited = new HashMap<>();
    private MapLocation curNode;

    public AStarFinding(MapSimulation map, AbstractCreature entity) {
        this.map = map;
        this.entity = entity;
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

    public void bfs() {
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

    public MapLocation start() {
        for (MapLocation location : map.keySet()) {
            List<MapLocation> locList = new ArrayList<>(getNextNode(location.getX(), location.getY()));
            graph.put(location, locList);
        }

        bfs();

        MapLocation path_segment = curNode;
        List<MapLocation> path = new ArrayList<>();

        while (path_segment != null) {
            path.add(path_segment);
            path_segment = visited.get(path_segment);
        }

        Collections.reverse(path);

        if (path.size() - 1 >= (entity.getSpeed())) {
            return path.get(entity.getSpeed());
        } else {
            return path.get(0);
        }

    }

    private Boolean checkNextNode(int x, int y) {
        if (0 <= x && x < map.getX() && 0 <= y && y < map.getY()) {
            return entity.getPreys().contains(map.getSimulationEntity(x, y).getType()) || map.getSimulationEntity(x, y).getType() == EmptyEntity.class
                    && entity.getType() != map.getSimulationEntity(x, y).getType();
        } else {
            return false;
        }
    }

}
