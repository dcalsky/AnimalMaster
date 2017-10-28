package example;
import manager.manager;
public class Manager extends manager {
    public Manager(String name)
    {
        super(name);
    }

    @Override
    public void custom_work() {
        System.out.println("feed pig");
    }

    public static void main(String []args)
    {
        Manager man = new Manager("");
        man.work_flow();
}
}
