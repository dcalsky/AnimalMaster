/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueReview;

import Example.FastReviewBuilder;//
import Example.SlowReviewBuilder;//
import FarmManager.FarmManager;
import QueueReview.ReviewFlowBuilder;
import example.Animal;

/**
 *
 * @author 18359
 */
//队列评审人员
public class QueueReviewer extends FarmManager{
    ////////////////////////////////////////////////////////////////////////////
    //builder design pattern
     private ReviewFlowBuilder reviewFlowBuilder;
     public ReviewFlow getReviewFlowMethod() { return reviewFlowBuilder.getReviewMethod(); }
     public void setReviewFlowBuilder(ReviewFlowBuilder pd){ reviewFlowBuilder = pd; }
     public void constructReviewFlow(){
         reviewFlowBuilder.createReviewFlow();
         reviewFlowBuilder.buildReacyAction();
         reviewFlowBuilder.buildMoveAction();
         reviewFlowBuilder.buildEndAction();
     }
     
     public static void main(String args[]){
        QueueReviewer reviewer = new QueueReviewer();
       FastReviewBuilder fastReviewBuilder = new FastReviewBuilder();
       SlowReviewBuilder slowReviewBuilder = new SlowReviewBuilder();
       
       reviewer.setReviewFlowBuilder(slowReviewBuilder);
       reviewer.constructReviewFlow();
       ReviewFlow reviewFlow = reviewer.getReviewFlowMethod();
       System.out.println( "The Review Command is: " + reviewFlow.getCommand());
       
       Animal pig = new Animal("pig1"); 
       pig.execute_command(reviewFlow);
    }
}
