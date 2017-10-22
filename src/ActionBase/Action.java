/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionBase;

import Root.GameObject;
import java.util.HashMap;
import java.util.Vector;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 * @author 18359
 */

public abstract class Action {
    protected static HashMap<Action, Vector<GameObject> >  _action = new HashMap<>();
    protected String actionName;
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
    protected static void addPrototype(Action action){ _action.put(action, new Vector()); }
    protected abstract Action clone();
    protected abstract void act();
    
    public static Action findAndClone(String type){
        for(Action action : _action.keySet()){
            //System.out.println(action.getClass().getName()+" "+_action.keySet().size());
            if(action.getClass().getName().equals(type)){
                return action.clone();
            }
        }
        System.out.println(type+" not found");
        return null;
    }
    
    public static void showContent(){
        for(Action action: _action.keySet()){
            //System.out.println(action.getClass().getName());
            action.act();
        }
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Observer Design pattern
    
    //向Map中对应的action注册Observer
    public void attach(Action action, GameObject go){
            if(_action.containsKey(action)){
                _action.get(action).add(go);
                Vector<GameObject> v = _action.get(action);
                for(GameObject gob: v){
                    //System.out.println(gob.getClass().getName()+" "+action.getClass().getName());
                }
            }else{
                System.out.println("not exist");
            }
            //action1.act();
    }

    public void dettach(Action action, GameObject go){
        if(_action.containsKey(action)){
            if(!_action.get(action).contains(go)){
                System.out.println(go.getClass().getName()+" does not have action "+action.getClass().getName());
            }
            _action.get(action).remove(go);
            Vector<GameObject> v = _action.get(action);
                
            for(GameObject gob: v){
                //System.out.println(gob.getClass().getName()+" "+action.getClass().getName());
            }
        }else{
            System.out.println("not exist the action");
        }
        for(Action action1 : _action.keySet()){
            System.out.println(action1.getClass().getName());
            for(GameObject v:_action.get(action1)){
                System.out.println(v.getClass().getName());
            }
        }
    }
    
}
