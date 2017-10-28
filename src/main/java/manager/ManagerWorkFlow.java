package manager;
import manager.Manager;
import action.Action;
import node.Node;

public class ManagerWorkFlow implements Action {
    private String work = "default work";
    private Node node;
    @Override
    public Node wrap(Node n)
    {
        int id = n.getID();
        if(n instanceof Manager)
        {
            System.out.println(""+id+" manager "+this.work);
        }
        else
        {
            System.out.println(n.getID()+"is not a manager");
        }
        return n;
    }


    public ManagerWorkFlow(String work,Node node)
    {
        this.work = work;
        this.node = node;
    }

}
