package sample;

import sample.Animal;
import state.LivingState;

public class AnimalState implements LivingState {
    private Animal animal;

    int power = 20;

    AnimalState(Animal a) {
        this.animal = a;
    }

    @Override
    public void dead() {
        System.out.println(animal.nickname + " is Dead!");
    }

    @Override
    public void grow() {
        power += 2;
    }

    @Override
    public void born() {

    }

    public void jump() {
        System.out.println("Oh, I'm jumping!!!");
    }
}