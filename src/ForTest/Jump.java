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
public class Jump extends Action {

    public Jump(String jump) {
        actionName = jump;
    }
    ////////////////////////////////////////////////////////////////////////////
    //Prototype Design pattern
    @Override
    public Action clone(){ return new Jump("jump"); }
    
    private Jump(){ super.addPrototype(this); }

    private static Jump _jump = new Jump();
    
    ////////////////////////////////////////////////////////////////////////////
    //Observer Design Pattern
    
    ////////////////////////////////////////////////////////////////////////////
    //每个动作类特有动作
    
    protected String actionName = "jump";

    @Override
    public String getActionName() {
        return actionName;
    }

    @Override
    public void act(){
        System.out.println(actionName);
    }
}
