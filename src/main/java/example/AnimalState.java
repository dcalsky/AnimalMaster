package example;

import state.LivingState;

public class AnimalState implements LivingState {
    private Animal animal;

    int power = 10;
    AnimalState(Animal a) {
        this.animal = a;
    }

    @Override
    public void dead() {
        System.out.println(animal.type + " is Dead!");
    }

    @Override
    public void grow() {
        power += 5;
    }

    @Override
    public void born() {

    }

    public void speak() {
        System.out.println("AOAO!");
    }
}