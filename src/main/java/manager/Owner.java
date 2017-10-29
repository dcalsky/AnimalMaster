package manager;
import action.Action;
import com.sun.xml.internal.ws.api.pipe.FiberContextSwitchInterceptor;

import java.util.ArrayList;
import java.util.Hashtable;


public class Owner extends Manager{
    private ArrayList<ManagerWorkFlow> work_flow = new ArrayList<ManagerWorkFlow>();
    private Hashtable<Integer,Worker> worker_map = new Hashtable<Integer, Worker>();
    private Delegate delegate ;
    public Owner(String name)
    {
        super(name);
    }

    public boolean add_worker(Worker... workers)
    {
        for(Worker m : workers)
        {
            try {
                worker_map.put(m.getID(),m);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean delete_worker(Worker... workers)
    {
        try {
            for(Worker m : workers)
            {
                worker_map.remove(m.getID());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public void arrange_worker(int id ,Delegate delegate)
    {
        this.delegate = delegate;
        int priority = delegate.getPriority();
        String message = delegate.getMessage();
        ArrayList<ManagerWorkFlow> old_wf = worker_map.get(id).get_work_flow();
        ArrayList<ManagerWorkFlow> delegate_wf = delegate.getActionList();
        ArrayList<ManagerWorkFlow> new_wf = new ArrayList<ManagerWorkFlow>();
        System.out.println("arrange worker the delegate message is"+message);

        if( priority >= old_wf.size())
            priority = old_wf.size();

        new_wf.addAll(old_wf.subList(0,priority));
        new_wf.addAll(delegate_wf);
        new_wf.addAll(old_wf.subList(priority,old_wf.size()));

        worker_map.get(id).manage_work(new_wf);
    }
    @Override
    public void manage_work(ArrayList<ManagerWorkFlow> s)
    {
        this.work_flow = s;
    }

    @Override
    public void custom_work()
    {
        for(ManagerWorkFlow a : work_flow)
        {
            a.wrap(this);
        }
    }
}
