package Action;

import node.Living;

import java.lang.annotation.*;


public abstract class Action extends Living {
    private Living _living;

    public Action(Living living){
        _living = living;
    }

//    public void act(){
//        System.out.println("nothing");
//    }

}
