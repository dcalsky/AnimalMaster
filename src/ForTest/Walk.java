/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ForTest;

import ActionBase.Action;

/**
 *
 * @author 18359
 */
public class Walk extends Action {

    public Walk(String walk) {
       actionName = walk;
    }
    ////////////////////////////////////////////////////////////////////////////
    //Prototype Design pattern
    @Override
    public Action clone(){ return new Walk("walk"); }
    //为了和私有构造函数区(防止调用两次addPrototype)分开添加一个参数，也可以修改为其他有意义的参数(还没想到)
    
    private Walk(){ super.addPrototype(this); }
    private static Walk _walk = new Walk();
    
    ////////////////////////////////////////////////////////////////////////////
    //Observer Design Pattern
    
    
    ////////////////////////////////////////////////////////////////////////////
    //每个动作类特有方法
    protected String actionName = "walk";

    @Override
    public String getActionName() {
        return actionName;
    }

    @Override
    public void act(){
        System.out.println(actionName);
    }
    
}


