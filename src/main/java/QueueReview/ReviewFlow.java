/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueReview;

import action.Action;
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
}
