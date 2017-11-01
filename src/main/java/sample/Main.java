package sample;

import container.Building;
import farm.FarmMemento;
import group.FarmIterator;
import group.Group;
import node.Food;
import sample.AnimalEquipment;
import farm.Farm;
import node.Living;

public class Main {
    public static void main(String[] args) throws Exception {

        Farm mmtFarm = Farm.getInstance();

        Living dog = Animal.create("dogA");
        Animal cat = new Animal("cat miao");
        Animal catB = new Animal("catB miao");

        cat.eat();

        mmtFarm.add(dog);
        mmtFarm.add(cat);

        SwimAction swim = new SwimAction();

        dog.do_action(swim);

        Animal.all_do_action(swim);

        AnimalEquipment pig1Equip = new AnimalEquipment("pig's sty");
        pig1Equip.setDresser(cat);
        pig1Equip.printStatus();


        // Evolution
        cat = new Adapter(new AfterEvolution("SmartPig"));
        cat.jump();

        FarmMemento farm_state = new FarmMemento(mmtFarm);
        mmtFarm.rebuild(new LargeFarmLevel());
        mmtFarm.restore(farm_state.get_state());
        System.out.println(mmtFarm.get_level());

        TestManager test_manager = new TestManager("lsl");
        test_manager.lsl.work_flow();


        // lsl get a knife
        test_manager.lsl.mount_equipment(new Knife());

        // Don't kill cat!!!
        test_manager.lsl.use_equipment_to(cat);

        Building building = new Building();
        building.addAcceptableClass(Animal.class);

        building.add(new Animal());
        System.out.println();

        // Food Decorator
        Food c1 = Food.create("beef");
        System.out.println(c1.getName());
        RoastFood roastFood = new RoastFood(c1);
        System.out.println(roastFood.getName());

        // Group
        Group<Animal> animals = new Group<>(15);
        Farm farm = Farm.getInstance();
        animals.add(cat);
        Animal sheep = new Animal("sheep1");
        animals.add(sheep);
        animals.allDoAction(swim);
        FarmIterator iterator = new FarmIterator(animals);
        iterator.allDoAction(swim);


    }
}
