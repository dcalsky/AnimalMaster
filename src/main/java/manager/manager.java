package manager;
import node.Node;

//Template design pattern
abstract public class manager extends Node{
    private String manager_name = "default name";
    public manager(String name)
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

    private void get_up()
    {
        System.out.println(""+manager_name+"起床了");
    }

    abstract protected void custom_work();

    private void sleep()
    {
        System.out.println(""+manager_name+"睡觉了");
    }
}
