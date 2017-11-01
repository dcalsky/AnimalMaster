package sample;

import farm.Farm;
import farm.FarmMemento;
import node.Living;


public class Animal extends Living {
    public int volumn = 0;
    public AnimalState state = new AnimalState(this);
    String nickname;

    public Animal() {
    }

    public Animal(String n) {
        nickname = n;
    }

    public void jump() {
        state.jump();
    }

    public void eat() {
        state.grow();
        System.out.println("I'm eating!");
    }
}
