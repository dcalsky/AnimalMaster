/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueReview;

import QueueReview.ReviewFlowBuilder;

/**
 *
 * @author 18359
 */
public class FastReviewBuilder extends ReviewFlowBuilder {

    @Override
    public void buildReacyAction() {
        reviewMethod.setReadyActionCommand("Standing");
    }

    @Override
    public void buildMoveAction() {
        reviewMethod.setMoveActionCommand("Run");
    }

    @Override
    public void buildEndAction() {
        reviewMethod.setEndActionCommand("Standing");
    }
    
}
