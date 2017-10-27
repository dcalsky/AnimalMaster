package container;

import node.Node;

import java.util.ArrayList;
import java.util.List;

public class SpaceContainer {
    protected List<Node>  spaceHolder = new ArrayList<>();
    protected static int MAX = 100;

    public void add(Node node) throws Exception{
        if(checkIfFull())
            throw  new Exception("Container Full Exception");
        spaceHolder.add(node);
    }

    protected boolean checkIfFull(){
        return spaceHolder.size() >= MAX;
    }

}
