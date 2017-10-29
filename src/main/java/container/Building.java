package container;

import node.Node;

import java.util.ArrayList;
import java.util.List;

public class Building extends SpaceContainer{
    private List<Class> acceptableClasses = new ArrayList<>();

    public Building(){
        super(100);
    }

    @Override
    public void add(Node node) throws Exception {
        boolean judge = false;
        for( Class clz : acceptableClasses ){
            if (clz.isAssignableFrom(node.getClass())){
                judge = true;
                break;
            }
        }
        if(!judge)
            throw new Exception("The instance of the class cannot be added into building");
        super.add(node);
    }

    public void addAcceptableClass(Class clz){
        if(clz != null)
            acceptableClasses.add(clz);
    }

    public void removeAcceptableClass(Class clz){
        acceptableClasses.remove(clz);
    }

    
}
