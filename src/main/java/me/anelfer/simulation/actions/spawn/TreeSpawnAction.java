package me.anelfer.simulation.actions.spawn;

import me.anelfer.simulation.entities.object.TreeEntity;
import me.anelfer.simulation.map.MapSimulation;

public class TreeSpawnAction extends AbstractSpawnAction{

    public TreeSpawnAction(int max, MapSimulation map) {
        super(map, max, new TreeEntity());
    }

}
