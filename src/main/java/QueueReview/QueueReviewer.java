/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueReview;

import FarmManager.FarmManager;
import QueueReview.ReviewFlowBuilder;
import Root.GameObject;

/**
 *
 * @author 18359
 */
//队列评审人员
public class QueueReviewer extends FarmManager{
    ////////////////////////////////////////////////////////////////////////////
    //prototype design pattern
    public static QueueReviewer instance = new QueueReviewer();
    @Override
    public GameObject clone(){return new QueueReviewer();}
    public QueueReviewer(int dummy){ }
    public void destroy(){super.destroy(this);}
    private QueueReviewer(){super.addPrototype(this);}
    public static QueueReviewer Clone(){return new QueueReviewer();}
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
}
