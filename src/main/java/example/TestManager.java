package example;

import manager.*;
import manager.ManagerWorkFlow;

import java.util.ArrayList;


public class TestManager {
    private Owner jjh = new Owner("jjh");

    public TestManager(String name) {

        WorkFactory wf = WorkFactory.get_instance();
        ManagerWorkFlow feed_fish = wf.get_work("feed_dog", jjh);
        ManagerWorkFlow feed_pig = wf.get_work("feed_pig", jjh);
        ArrayList<ManagerWorkFlow> s = new ArrayList<ManagerWorkFlow>() {
            {
                add(feed_fish);
                add(feed_pig);
            }
        };
        jjh.manage_work(s);
    }

    public static void main(String[] args) {
        TestManager test_manager = new TestManager("jjh");
        test_manager.jjh.work_flow();


        // jjh get a knife
        test_manager.jjh.mount_equipment(new Knife());

        // initialize a pig instance
        Animal pig = new Animal("pigA");
        test_manager.jjh.use_equipment_to(pig);
    }
}
