package state;

import node.Living;

/* Build-in state for living objects */
public class DefaultLivingState implements LivingState {
    private Living living;

    int health = 0;
    int weight = 10;

    public DefaultLivingState(Living l) {
        living = l;
    }
    @Override
    public void dead() {
        this.health = 0;
    }

    @Override
    public void grow() {
        weight += 10;
    }


    @Override
    public void born() {
        this.health = 100;
    }
}
