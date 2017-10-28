/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Example;

import QueueReview.ReviewFlow;
import QueueReview.ReviewFlowBuilder;

/**
 *
 * @author 18359
 */
public class SlowReviewBuilder extends ReviewFlowBuilder {
    
    @Override
    public void buildReadyAction() {
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

    @Override
    public void createReviewFlow(ReviewFlow flow) {
       flow.attach(this);
       reviewMethod = new ReviewFlow();
    }
    
}
