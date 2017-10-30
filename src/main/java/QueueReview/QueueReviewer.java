package QueueReview;

import example.FastReviewBuilder;//
import example.SlowReviewBuilder;//
import QueueReview.ReviewFlowBuilder;
import example.Animal;
import example.FastReviewBuilder;
import manager.Manager;

//队列评审人员
public class QueueReviewer {
    //builder design pattern
     private ReviewFlowBuilder reviewFlowBuilder;
     public ReviewFlow getReviewFlowMethod() { return reviewFlowBuilder.getReviewMethod(); }
     public void setReviewFlowBuilder(ReviewFlowBuilder pd){ reviewFlowBuilder = pd; }
     public void constructReviewFlow(ReviewFlow flow){
         reviewFlowBuilder.createReviewFlow(flow);
         reviewFlowBuilder.buildReadyAction();
         reviewFlowBuilder.buildMoveAction();
         reviewFlowBuilder.buildEndAction();
     }
}
