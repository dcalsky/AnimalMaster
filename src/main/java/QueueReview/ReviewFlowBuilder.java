package QueueReview;

import java.util.ArrayList;
import java.util.List;
import node.Node;

/**
 *
 * @author 18359
 */
public abstract class ReviewFlowBuilder extends Node implements Observer {
    protected ReviewFlow reviewMethod;
    public ReviewFlow getReviewMethod(){ return reviewMethod; }
    
    public abstract void createReviewFlow(ReviewFlow flow);
    public abstract void buildReadyAction();
    public abstract void buildMoveAction();
    public abstract void buildEndAction();
    
    public void setSubject(ReviewFlow flow){
        flow.attach(this);
    }
    
    public void updateReadyAction(String actionName){
        System.out.println(actionName);
        reviewMethod.setReadyActionCommand(actionName);
    }
    public void updateMoveAction(String actionName){
        reviewMethod.setMoveActionCommand(actionName);
    }
    public void updateEndAction(String actionName){
        reviewMethod.setEndActionCommand(actionName);
    }
}
