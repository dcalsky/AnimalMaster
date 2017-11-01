package sample;

import farm.BaseFarmLevel;

public class LargeFarmLevel extends BaseFarmLevel {

    protected int capacity = 100;

    @Override
    public void expand() {
        this.capacity += 50;
    }

    @Override
    public void shrink() {
        this.capacity -= 50;
    }

}
