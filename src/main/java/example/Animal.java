package example;

import farm.Farm;
import farm.FarmMemento;
import node.Living;


public class Animal extends Living {
    public int volumn = 0;
    public AnimalState state = new AnimalState(this);
    String type;

    public Animal() {}
    public Animal(String n) {
        type = n;
    }

    public void speak() {
        state.speak();
    }

    public void eat() {
        state.grow();
        System.out.println("Eat eat!");
    }
}
