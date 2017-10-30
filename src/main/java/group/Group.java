package group;

import action.Action;
import example.Animal;
import example.FlyAction;
import farm.Farm;

import java.util.ArrayList;

public class Group<T> extends ArrayList<T> {
    private int maxSize;
    private FarmIterator iteratorT;

    public Group(int size){
        maxSize = size;
        iteratorT = new FarmIterator(this);
    }

    @Override
    public boolean add(T t) {
        if (maxSize > this.size()){
            return super.add(t);
        }
        else {
            throw new Error("The group is full!");
        }
    }

    public void allDoAction(Action action){
        iteratorT.allDoAction(action);
    }
}
