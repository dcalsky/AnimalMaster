/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueReview;

/**
 *
 * @author 18359
 */
public abstract class ReviewFlowBuilder {
    protected ReviewFlow reviewMethod;
    
    public ReviewFlow getReviewMethod(){ return reviewMethod; }
    
    public void createReviewFlow() { reviewMethod = new ReviewFlow(); }
    public abstract void buildReacyAction();
    public abstract void buildMoveAction();
    public abstract void buildEndAction();
}
