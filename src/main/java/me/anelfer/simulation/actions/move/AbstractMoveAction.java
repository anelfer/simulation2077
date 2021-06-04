package me.anelfer.simulation.actions.move;

import me.anelfer.simulation.actions.AbstractAction;

public abstract class AbstractMoveAction extends AbstractAction {

    public abstract void move();

    @Override
    public void perform() {
        move();
    }

}
