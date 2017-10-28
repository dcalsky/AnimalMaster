/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueReview;

import java.util.ArrayList;
import java.util.List;
import node.Node;

public class ReviewFlow extends Node{
    ////////////////////////////////////////////////////////////////////////////
    // builder design pattern 实现动物接受检阅的流程
    private String _queueReadyAction;//动物列队方式
    private String _queueMoveAction;//动物进行检阅时前进方式
    private String _queueEndAction;//动物队列终止时动作
    
    public void setReadyActionCommand(String action){ _queueReadyAction = action; }
    public void setMoveActionCommand(String action){ _queueMoveAction = action; }
    public void setEndActionCommand(String action){ _queueEndAction = action; }
    
    public String getCommand(){ return _queueReadyAction+" "+_queueMoveAction+" "+_queueEndAction; }
    ////////////////////////////////////////////////////////////////////////////
    private static List<Observer> observers = new ArrayList();
     public void attach(Observer ob){
        observers.add(ob);
    }

    public void detach(Observer ob){
        observers.remove(ob);
    }
    
    //用户可以对动作进行微调，比如说walk变成walk slower
    public void changeAllReadyAction(String actionName){
        setReadyActionCommand(actionName);
        notifyObserverReady(actionName);
    }
    
    public void changeAllMoveAction(String actionName){
        setReadyActionCommand(actionName);
        notifyObserverMove(actionName);
    }
    
    public void changeAllEndAction(String actionName){
        setEndActionCommand(actionName);
        notifyObserverEnd(actionName);
    }
    
    public void notifyObserverReady(String actionName){
        for(Observer ob: observers){
            System.out.println(ob.getClass());
            //ob.updateReadyAction(actionName);
        }
    }
    
    public void notifyObserverMove(String actionName){
        for(Observer ob: observers){
            ob.updateMoveAction(actionName);
        }
    }
    
    public void notifyObserverEnd(String actionName){
        for(Observer ob: observers){
            ob.updateEndAction(actionName);
        }
    }
}
