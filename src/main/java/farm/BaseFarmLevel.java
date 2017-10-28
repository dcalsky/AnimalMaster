package farm;

public class BaseFarmLevel implements FarmLevel {
    private int capacity = 20;

    @Override
    public void expand() {
        capacity += 5;
    }

    @Override
    public void shrink() {
        capacity -= 5;
    }

    @Override
    public int get_capacity() {
        return this.capacity;
    }
}
