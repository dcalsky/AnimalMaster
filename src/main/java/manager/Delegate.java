package manager;

import action.Action;

import java.util.ArrayList;
import java.util.List;

public class Delegate {
    private List<Action> actionList = new ArrayList<>();
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

    public void push(Action... actions){
        for(Action action : actions){
            actionList.add(action);
        }
    }

    public String getMessage() {
        return message;
    }
}
