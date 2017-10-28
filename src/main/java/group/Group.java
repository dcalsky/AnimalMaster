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


    public static void main(String[] args){
        Group<Animal> animals = new Group<>(10);
        Farm farm = Farm.getInstance();
        Animal pig = new Animal("pig1");
        animals.add(pig);
        Animal sheep = new Animal("sheep1");
        animals.add(sheep);
        FlyAction flyAction = new FlyAction();
        animals.allDoAction(flyAction);
        FarmIterator iterator = new FarmIterator(animals);
        iterator.allDoAction(flyAction);
    }
}
