package example;

import QueueReview.QueueReviewer;
import QueueReview.ReviewFlow;
import farm.Farm;
import farm.FarmMemento;
import group.FarmIterator;
import group.Group;
import node.Food;

public class Usage {
    public static void main(String[] args) {

        // Farm initialize
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

        // Test for equipment
        Equipment pig1Equip = new Equipment("pig's sty");
        pig1Equip.setDresser(pig1);
        pig1Equip.printStatus();


        // Evolution
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

        // Create manager
        TestManager test_manager = new TestManager("jjh");
        test_manager.jjh.work_flow();


        // jjh get a knife
        test_manager.jjh.mount_equipment(new Knife());

        // initialize a pig instance
        Animal pig = new Animal("pigA");
        test_manager.jjh.use_equipment_to(pig);

        // Work manage
        WorkManage test_work_manage = new WorkManage();

        // Test for building
        Building building = new Building();
        building.addAcceptableClass(Animal.class);
        try {
            building.add(new Animal());
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Food Decorator
        Food c1 = Food.create("chicken");
        System.out.println(c1.getName());
        RoastFood roastFood = new RoastFood(c1);
        System.out.println(roastFood.getName());

        // Group
        Group<Animal> animals = new Group<>(10);
        Farm farm = Farm.getInstance();
        animals.add(pig);
        Animal sheep = new Animal("sheep1");
        animals.add(sheep);
        animals.allDoAction(flyAction);
        FarmIterator iterator = new FarmIterator(animals);
        iterator.allDoAction(flyAction);

	//Queue Review
        QueueReviewer reviewer = new QueueReviewer();
        ReviewFlow flow = new ReviewFlow();
        Animal pigQueue = new Animal("pig222");
        FastReviewBuilder fastReviewBuilder = new FastReviewBuilder();
        reviewer.setReviewFlowBuilder(fastReviewBuilder);
        reviewer.constructReviewFlow(flow);
        flow = reviewer.getReviewFlowMethod();
        System.out.println("The Command is: "+flow.getCommand());
        pigQueue.execute_command(flow);
        SlowReviewBuilder slowReviewBuilder = new SlowReviewBuilder();
        reviewer.setReviewFlowBuilder(slowReviewBuilder);
        reviewer.constructReviewFlow(flow);
        flow = reviewer.getReviewFlowMethod();
        System.out.println("The Command is: "+flow.getCommand());
        pigQueue.execute_command(flow);
        
        flow.changeAllEndAction("fly");
        pigQueue.execute_command(flow);
        
        flow.changeAllMoveAction("jump");
        pigQueue.execute_command(flow);
        
        flow.changeAllReadyAction("haha");
        pigQueue.execute_command(flow);
    }

}
