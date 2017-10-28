package node;

public abstract class Node {
    private static int count = 0;
    private int ID;


    protected Node() {
        ID = Node.count ++ ;
    }

    public static int get_count() {
        return Node.count;
    }

    public int getID() {
        return ID;
    }
}
