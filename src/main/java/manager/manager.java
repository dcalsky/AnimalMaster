package manager;
import node.Node;

import java.util.ArrayList;

//Template design pattern
abstract public class Manager extends Node{
    private String manager_name = "default name";
    public Manager(String name)
    {
        super();
        manager_name = name;
    }
    final  public void work_flow()
    {
        this.get_up();
        this.custom_work();
        this.sleep();
    }

    public String get_name()
    {
        return manager_name;
    }

    private void get_up()
    {
        System.out.println(""+manager_name+" get up");
    }

    abstract protected void manage_work(ArrayList<ManagerWorkFlow>s);
    abstract protected void custom_work();

    private void sleep()
    {
        System.out.println(""+manager_name+" sleep");
    }
}
