/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionBase;

import Root.GameObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author 18359
 */

public abstract class Action extends GameObject {
    protected List<Observer> observers = new ArrayList();//observer pool
    private static List<Action> objs = new ArrayList();
    protected String _actionName;
    //Action子类作为subject，每一个setAction的动物作为observer，Action及其子类的实现使用Prototype Design Pattern
    ////////////////////////////////////////////////////////////////////////////
    protected Action() { }
    
    protected void destroy(Action action){
	super.destroy(action);
	objs.remove(action);
    }
    //所有继承类需要重载destroy
    public static int getNumber()
    {
	Set<String> set = new HashSet<>();
	for(Action go : objs)
	{
	    set.add(go.getClass().getName());
	}
	System.out.println("objs: " +objs.size());
	System.out.println("set: " + set.size());
	return objs.size() - set.size();
    }
    
    protected void addPrototype (Action action) {
	super.addPrototype(action);
	objs.add(action);
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //getter and setter
    public String getActionName(){
        return _actionName;
    }
    
    public void setActionName(String actionName){
        _actionName = actionName;
    }
    
    //此函数用于测试
    public void showContent(){
        for(Action action:objs){
            System.out.println(action.getClass().getName());
        }
        for(Observer ob:observers){
            System.out.println(ob.getClass().getName()+" "+this.getClass().getName());
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //Observer Design pattern
    
    public void attach(Observer ob){
        observers.add(ob);
    }

    public void detach(Observer ob){
        observers.remove(ob);
    }
    
    //用户可以对动作进行微调，比如说walk变成walk slower
    public void changesToAction(String actionName){
        _actionName = actionName;
        notifyObserver();
    }
    
    public void notifyObserver(){
        for(Observer ob: observers){
            ob.update(_actionName);
        }
    }
    
    
}
