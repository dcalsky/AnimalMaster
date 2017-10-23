package BaseClass;

import ActionBase.Action;
import Root.GameObject;
import farmobjects.LivingObjects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Animal extends LivingObjects
{
    private static List<Animal> objs = new ArrayList<>();
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
    
     public void setAction(Action action){
        //System.out.println(action.getClass().getName()+" "+this.getClass().getName());
        action.attach(action, this);
    }
     
     public void deleteAction(Action action){
         action.dettach(action,this);
     }

}
