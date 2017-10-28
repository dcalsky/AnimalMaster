package manager;
import node.Node;
import java.util.Hashtable;


public class WorkFactory {
    private Hashtable<String,ManagerWorkFlow> work_pool = new Hashtable<String, ManagerWorkFlow>();
    private static WorkFactory singleton = new WorkFactory();


    private WorkFactory(){};
    public static WorkFactory get_instance()
    {
        return singleton;
    }

    public synchronized ManagerWorkFlow get_work(String work_name, Node node)
    {
        ManagerWorkFlow wf = (ManagerWorkFlow)work_pool.get(""+work_name);
        if(null == wf)
        {
            wf = new ManagerWorkFlow(""+work_name,node);
            work_pool.put(""+work_name,wf);
        }
        return wf;
    }
}
