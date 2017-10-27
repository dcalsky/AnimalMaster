package Group;

import node.Node;

import java.util.Iterator;
import java.util.Vector;

public class Group extends Node {
    private String _group_name;
    private Vector<Node> group = new Vector<Node>();

    public Group(String name){
        _group_name = name;
    }

    public String getName(){
        return _group_name;
    }

    public int getTotalNum(){
        int num = 0;
        Iterator it = group.iterator();
        while (it.hasNext()){
            Node node = (Node)it.next();
            num += 1;
        }
        return num;
    }

    public Node add(Node node){
        group.add(node);
        return this;
    }
}
