package example;

import farm.Farm;
import farm.FarmMemento;
import node.Living;


public class Animal extends Living {
    public int volumn = 0;
    private AnimalState state = new AnimalState(this);
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

    public static void main(String args[]) {
        Farm myFarm = Farm.getInstance();

        Animal pig1 = new Animal("pig1");
        Animal pig2 = new Animal("pig2");
        myFarm.add(pig1);
        pig1.speak();
        pig1.eat();
        FlyAction flyAction = new FlyAction();
        // pig1 does action => fly
        pig1.do_action(flyAction);
        // Farm count
        System.out.println("Number of animal in farm: " + myFarm.getNumber());
        // all animals do action => fly fly
        Animal.all_do_action(flyAction);

        //进化
        pig1 = new Adapter(new AfterEvolution("SmartPig"));
        pig1.speak();

        // Record farm state
        System.out.println("Step1");
        FarmMemento farm_state = new FarmMemento(myFarm);
        System.out.println(myFarm.get_level());
        // Change farm state
        System.out.println("Step2");
        myFarm.rebuild(new SmallFarmLevel());
        System.out.println(myFarm.get_level());
        // restore farm state
        System.out.println("Step3");
        myFarm.restore(farm_state.get_state());
        System.out.println(myFarm.get_level());
    }
}
