package example;

import farm.Farm;
import node.Living;

public class Animal extends Living {
    public int volumn = 0;
    private AnimalState state = new AnimalState(this);
    String type;

    Animal() {}
    Animal(String n) {
        type = n;
    }

    public void speak() {
        state.speak();
    }

    public void eat() {
        state.grow();
        System.out.println("Eat eat!");
    }

    public static void main(String args[]) {
        Farm myFarm = Farm.getInstance();

        Animal pig = new Animal("pig1");
        pig.speak();
        pig.eat();
        FlyAction flyAction = new FlyAction();
        pig.do_action(flyAction);

        //进化
        pig = new Adapter(new AfterEvolution("SmartPig"));
        pig.speak();
    }
}
