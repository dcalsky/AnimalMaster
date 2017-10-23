package farmobjects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import space.SpaceHolder;

public abstract class LivingObjects extends SpaceHolder {

	private static List<LivingObjects> objs = new ArrayList<>();
    //每有一个新的类继承GameObject或者任何一个GameObeject的子类，除非这个类是final类型，否则需要为他添加private static的list
    
    protected LivingObjects() { }
    protected void addPrototype (LivingObjects livingObjects) {
    	super.addPrototype(livingObjects);
    	objs.add(livingObjects);
    }
    //所有非final类都需要重载addPrototype方法，实现方法是super.addPrototype(参数);list.add(参数);
    
    public static int getNumber()
    {
		Set<String> set = new HashSet<>();
		for(LivingObjects livingObjects : objs)
		{
	        set.add(livingObjects.getClass().getName());
		}
		System.out.println("objs: " + objs.size());
	    System.out.println("set: " + set.size());
		return objs.size() - set.size();
    }
    //所有非final类需要实现public static的getNumber
    
    protected void destroy(LivingObjects livingObjects){
    	super.destroy(livingObjects);
    	objs.remove(livingObjects);
    }

}
