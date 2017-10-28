package container;

import node.Node;

import java.util.ArrayList;
import java.util.List;

public class SpaceContainer extends Node{
    protected List<Node>  spaceHolder = new ArrayList<>();
    protected static int MAX;

    protected SpaceContainer(int capacity){
        MAX = capacity;
    }

    public void add(Node node) throws Exception{
        if(checkIfFull())
            throw  new Exception("Container Full Exception");
        spaceHolder.add(node);
    }

    public boolean remove(int id){
        for( Node node : spaceHolder ){
            if(node.getID() == id){
                spaceHolder.remove(node);
                return true;
            }
            else if( node instanceof SpaceContainer ){
                if ( ((SpaceContainer) node).remove(id) )
                    return true;
            }
        }
        return false;
    }

    protected boolean checkIfFull(){
        return spaceHolder.size() >= MAX;
    }

    public void setCapacity(int capacity) throws  Exception{
        if(capacity <= 0)
            throw new Exception("Container Capacity Exception: capacoty cannot be minus");
        MAX = capacity;
    }

    public void showElement(){
        showElement(0);
    }

    private void showElement(int level){
        for( Node node : spaceHolder ){
            for(int i=0 ; i<level ; ++i){
                System.out.print("\t");
            }
            if(node instanceof SpaceContainer){
                System.out.println(node.getClass().getName() + " : " +node.getID() +" {");
                ((SpaceContainer)node).showElement(level+1);
                for(int i=0 ; i<level ; ++i){
                    System.out.print("\t");
                }
                System.out.println("}");
            }
            else{
                System.out.println(node.getClass().getName() + " : " +node.getID());
            }
        }
    }


}
