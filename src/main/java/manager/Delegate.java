package manager;



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import manager.Worker;

public class Delegate {
    private ArrayList<ManagerWorkFlow> actionList = new ArrayList<>();
    //priorit 0~9 0最大
    private int priority;
    private String message;

    public Delegate(String message){
        this.message = message;
        priority = 0;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        if (priority >9)
            priority = 9;
        else if(priority <0)
            priority = 0;
        this.priority = priority;
    }

    public void push(ManagerWorkFlow... actions){
        for(ManagerWorkFlow action : actions){
            actionList.add(action);
        }
    }


    public ArrayList<ManagerWorkFlow> getActionList()
    {
        return actionList;
    }


    public String getMessage() {
        return message;
    }
}
