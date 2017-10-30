package example;
import manager.*;

import java.util.ArrayList;

public class WorkManage {
    private Owner jjh = new Owner("jjh");
    private Worker zyh = new Worker("zyh");
    private WorkFactory wf = WorkFactory.get_instance();
    private Delegate delegate = new Delegate("schedule zyh's work");

    public WorkManage()
    {
        ManagerWorkFlow feed_fish = wf.get_work("feed_dog", zyh);
        ManagerWorkFlow feed_pig = wf.get_work("feed_pig", zyh);
        ArrayList<ManagerWorkFlow> s = new ArrayList<ManagerWorkFlow>() {
            {
                add(feed_fish);
                add(feed_pig);
            }
        };

        delegate.push(wf.get_work("feed monkey",zyh));
        delegate.setPriority(1);
        zyh.manage_work(s);

        jjh.add_worker(zyh);
        jjh.arrange_worker(zyh.getID(),delegate);
        zyh.custom_work();
    }
}
