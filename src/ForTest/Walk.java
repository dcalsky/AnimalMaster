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
public class Walk extends Action {

   public static Walk instance = new Walk();
    @Override
    public GameObject clone()
    {
	return new Walk("Walk");
    }
    
    public Walk(String actionName){
        _actionName = actionName;
    }
    
    public void destroy(){
	super.destroy(this);
    }
    
    private Walk()
    {
    	super.addPrototype(this);
    }
    
    public static Walk Clone()
    {
	return new Walk();
    }
    ////////////////////////////////////////////////////////////////////////////
    //每个动作类特有方法
    
}


