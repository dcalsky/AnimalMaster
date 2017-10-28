/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public void createReviewFlow() { reviewMethod = new ReviewFlow(); }
    public abstract void buildReadyAction();
    public abstract void buildMoveAction();
    public abstract void buildEndAction();
    
    public void updateReadyAction(String actionName){
        reviewMethod.setReadyActionCommand(actionName);
    }
    public void updateMoveAction(String actionName){
        reviewMethod.setMoveActionCommand(actionName);
    }
    public void updateEndAction(String actionName){
        reviewMethod.setEndActionCommand(actionName);
    }
}
