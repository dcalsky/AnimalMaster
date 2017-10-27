package node;

import java.util.HashSet;

public class Node {
    private static int count = 0;


    protected Node() {
        Node.count += 1;

    }

    public static Node create() {
        return new Node();
    }

    public static int get_count() {
        return Node.count;
    }
}
