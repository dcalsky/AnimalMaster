package sample;

import manager.ManagerWorkFlow;
import manager.Owner;
import manager.WorkFactory;

import java.util.ArrayList;


public class TestManager {
    public Owner lsl = new Owner("lsl");

    public TestManager(String name) {

        WorkFactory wf = WorkFactory.get_instance();
        ManagerWorkFlow feed_fish = wf.get_work("feed_dog", lsl);
        ManagerWorkFlow feed_pig = wf.get_work("feed_pig", lsl);
        ArrayList<ManagerWorkFlow> s = new ArrayList<ManagerWorkFlow>() {
            {
                add(feed_fish);
                add(feed_pig);
            }
        };
        lsl.manage_work(s);
    }
}
