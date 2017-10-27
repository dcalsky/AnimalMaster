package node;

public abstract class Node {
    private static int count = 0;


    protected Node() {
        Node.count += 1;
    }

    public static int get_count() {
        return Node.count;
    }
}
