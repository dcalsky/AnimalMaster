/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForTest;

import ActionBase.Action;
import Root.GameObject;

/**
 *
 * @author 18359
 */
public class Jump extends Action {
    
    public static Jump instance = new Jump();
    @Override
    public GameObject clone()
    {
	return new Jump("jump");
    }
    
    public Jump(String actionName){
        _actionName = actionName;
    }
    
    public void destroy(){
	super.destroy(this);
    }
    
    private Jump()
    {
    	super.addPrototype(this);
    }
    
    public static Jump Clone()
    {
	return new Jump();
    }
    ////////////////////////////////////////////////////////////////////////////
    //Observer Design Pattern
    
    
    ////////////////////////////////////////////////////////////////////////////
    //每个动作类特有方法
    
}
