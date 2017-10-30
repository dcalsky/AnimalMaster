package manager;

import node.Tool;
import node.Node;

import java.util.ArrayList;

//Template and command design pattern
abstract public class Manager extends Node {
    private String manager_name = "default name";
    private Tool tool; // Command carrier

    public Manager(String name) {
        super();
        manager_name = name;
    }

    final public void work_flow() {
        this.get_up();
        this.custom_work();
        this.sleep();
    }

    public void mount_equipment(Tool e) {
        this.tool = e;
    }

    public void unmount_equipment() {
        this.tool = null;
    }
    public void use_equipment_to(Node node) {
        tool.do_action(node);
    }

    public String get_name() {
        return manager_name;
    }

    private void get_up() {
        System.out.println("" + manager_name + " get up");
    }

    abstract protected void  manage_work(ArrayList<ManagerWorkFlow> s);

    abstract protected void custom_work();

    private void sleep() {
        System.out.println("" + manager_name + " sleep");
    }
}
