package manager;

import java.util.ArrayList;

public class Worker extends Manager{
    private ArrayList<ManagerWorkFlow> work_flow = new ArrayList<ManagerWorkFlow>();
    public Worker(String name)
    {
       super(name);
    }

    public ArrayList<ManagerWorkFlow> get_work_flow()
    {
        return work_flow;
    }

    @Override
    public void manage_work(ArrayList<ManagerWorkFlow> s) {
        this.work_flow = s;
    }

    @Override
    public void custom_work() {
        for(ManagerWorkFlow a : work_flow)
        {
            a.wrap(this);
        }
    }
}
