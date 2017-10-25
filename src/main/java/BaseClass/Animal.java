package BaseClass;

import ActionBase.Action;
import ActionBase.Observer;
<<<<<<< HEAD
import QueueReview.ReviewFlow;
import Root.GameObject;
import farmobjects.LivingObjects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Animal extends LivingObjects implements Observer
{
    private static List<Animal> objs = new ArrayList<>();
    protected List<Action> _action = new ArrayList<>();//一个动物会的所有动作
    //每有一个新的类继承GameObject或者任何一个GameObeject的子类，除非这个类是final类型，否则需要为他添加private static的list
    
    protected Animal() { }

    protected void addPrototype (Animal animal) {
	super.addPrototype(animal);
	objs.add(animal);
    }
    //所有非final类都需要重载addPrototype方法，实现方法是super.addPrototype(参数);list.add(参数);
    
    public static int getNumber()
    {
	Set<String> set = new HashSet<>();
	for(Animal go : objs)
	{
	    set.add(go.getClass().getName());
	}
	System.out.println("objs: " + objs.size());
	System.out.println("set: " + set.size());
	return objs.size() - set.size();
    }
    //所有非final类需要实现public static的getNumber
    
    protected void destroy(Animal animal){
	super.destroy(animal);
	objs.remove(animal);
    }
    //所有继承类需要重载destroy
    
    ////////////////////////////////////////////////////////////////////////////
    //Observer Design pattern
     public void setAction(Action action){
        //System.out.println(action.getClass().getName());
        _action.add(action);
        action.attach(this);
    }
     
     public void deleteAction(Action action){
         _action.remove(action);
         action.detach(this);
     }
     ///////////////////////////////////////////////////////////////////////////
     //显示该动物会的所有动作
     public void showAllAction(){
         for(Action action:_action){
             System.out.println(action.getClass().getName());
         }
     }
     
     //让动物执行动作
     public void execute(Action action){
         if(!_action.contains(action)){
             System.out.println("He can not do this action");
             return;
         }
         System.out.println(this.getClass().getName()+" "+action.getActionName());
     }
     ///////////////////////////////////////////////////////////////////////////
     //响应builder设计模式产生的command
     
     public void executeCommand(ReviewFlow command){
         if(_action.isEmpty()){
             System.out.println(this.getClass().getName()+" can not do any action");
             return;
         }
         String[] commands = command.getCommand().split("\\s+");
         for(String singleCommand:commands){
             for(Action action: _action){
                if(!action.getActionName().toUpperCase().equals(singleCommand.toUpperCase())){
                    System.out.println(this.getClass().getName()+" can not "+singleCommand);
                    return;
                }
             }
         }
         System.out.println(this.getClass().getName()+" "+command.getCommand());
     }
}
