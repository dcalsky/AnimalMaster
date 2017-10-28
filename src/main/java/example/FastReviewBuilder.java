/*
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Example;

import QueueReview.ReviewFlowBuilder;
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
