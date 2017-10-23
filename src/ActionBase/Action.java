/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionBase;

import Root.GameObject;

import java.util.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 * @author 18359
 */

public abstract class Action extends GameObject{
    protected List<Observer> observers = new ArrayList<>();
    private static List<Action> objs = new ArrayList<>();
    protected String actionName;

    public String getActionName() {
        return this.actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }


    //Vector是一个Observer pool,每一个setAction的动物类会添加到Action对应的Vector当中，Action及其子类使用Prototype设计模式
    //////////////////////////////////////////////////////////////////////////////////////////////
    //重载hashcode()与equals()
    @Override
    public boolean equals(Object o){
        return EqualsBuilder.reflectionEquals(this,o);
    }
    
    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this);
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////
    //Prototype Design pattern
    protected abstract Action clone();
    protected abstract void act();

    protected void addPrototype (Action action) {
        super.addPrototype(action);
        objs.add(action);
    }


    public static void showContent(){
        for(Action action: objs){
            System.out.println(action.getClass().getName());
            List<Observer> observers = action.getObservers();
            for(Observer ob : observers){
                ob.update();
            }
        }
    }

    public static void showContent2(){
        //List<Observer> observers = .getObservers();
//        for(Observer ob : observers){
//            ob.update();
//        }
    }

    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Observer Design pattern
    

    public void attach( Observer ob){
        Action action = findPrototype(this.getActionName());
        List<Observer> obs = action.getObservers();
        if(! obs.contains(ob)){
            obs.add(ob);
        }
    }

    public void dettach(Action action, Observer ob){
        observers.remove(ob);
    }

    public static int getNumber()
    {
        Set<String> set = new HashSet<>();
        for(Action go : objs)
        {
            set.add(go.getClass().getName());
        }
        System.out.println("objs: " + objs.size());
        System.out.println("set: " + set.size());
        return objs.size() - set.size();
    }

    protected void destroy(Action animal){
        super.destroy(animal);
        objs.remove(animal);
    }

    public List<Observer> getObservers() {
        return observers;
    }

    private Action findPrototype(String actionName){
        Action result = null;
        for (Action action : objs){
            if(action.getActionName() == actionName)
                result = action;
        }
        if (result != null)
            return result;
        return null;
    }


}
