package example;

import farm.BaseFarmLevel;
import farm.FarmLevel;

public class SmallFarmLevel extends BaseFarmLevel {

    protected int capacity = 20;

    @Override
    public void expand() {
        this.capacity += 10;
    }

    @Override
    public void shrink() {
        this.capacity -= 10;
    }

}
