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
     
     public static void main(String args[]){
       QueueReviewer reviewer = new QueueReviewer();
       
       FastReviewBuilder fastReviewBuilder = new FastReviewBuilder();
       SlowReviewBuilder slowReviewBuilder = new SlowReviewBuilder();
       
       ReviewFlow reviewFlow = new ReviewFlow();
       reviewer.setReviewFlowBuilder(slowReviewBuilder);
       reviewer.constructReviewFlow(reviewFlow);  
       //要使用observer必须set一次construct一次
       reviewer.setReviewFlowBuilder(fastReviewBuilder);
       reviewer.constructReviewFlow(reviewFlow);
       
       reviewFlow = reviewer.getReviewFlowMethod();
       
       //fastReviewBuilder.setSubject(reviewFlow);
       //slowReviewBuilder.setSubject(reviewFlow);
       System.out.println( "The Review Command is: " + reviewFlow.getCommand());
       
       Animal pig = new Animal("pig1"); 
       pig.execute_command(reviewFlow);
       
       reviewFlow.changeAllReadyAction("fly");
       pig.execute_command(reviewFlow);
       
     
       reviewFlow = reviewer.getReviewFlowMethod();
       System.out.println( "The Review Command is: " + reviewFlow.getCommand());
      // pig.execute_command(reviewFlow);*/
    }
}
