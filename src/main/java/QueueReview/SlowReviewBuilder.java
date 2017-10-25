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
public class SlowReviewBuilder extends ReviewFlowBuilder {

    @Override
    public void buildReacyAction() {
        reviewMethod.setReadyActionCommand("Squat");
    }

    @Override
    public void buildMoveAction() {
        reviewMethod.setMoveActionCommand("Walk");
    }

    @Override
    public void buildEndAction() {
        reviewMethod.setEndActionCommand("Squat");
    }
    
}
