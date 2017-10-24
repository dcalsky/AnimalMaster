package land;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import layer.LayerLayout;

public abstract class LandContainer extends Land{
	
	private static List<LandContainer> objs = new ArrayList<>();
	private ArrayList<Land> lands;
	private int size;
	private LayerLayout layout;
    //每有一个新的类继承GameObject或者任何一个GameObeject的子类，除非这个类是final类型，否则需要为他添加private static的list
    
    protected LandContainer() { }
    protected void setSize(int size)
    {
    	this.size=size;
    }
    protected void addPrototype (LandContainer landContainer) {
    	super.addPrototype(landContainer);
    	objs.add(landContainer);
    }
    //所有非final类都需要重载addPrototype方法，实现方法是super.addPrototype(参数);list.add(参数);
    
    public static int getNumber()
    {
		Set<String> set = new HashSet<>();
		for(LandContainer landContainer : objs)
		{
	        set.add(landContainer.getClass().getName());
		}
		System.out.println("objs: " + objs.size());
	    System.out.println("set: " + set.size());
		return objs.size() - set.size();
    }
    //所有非final类需要实现public static的getNumber
    
    protected void destroy(LandContainer landContainer){
    	super.destroy(landContainer);
    	objs.remove(landContainer);
    }
    //所有继承类需要重载destroy
    protected void add(Land land,int location) {
    	layout.setLayout(land, location);
		
	}
    protected abstract void initialize();

}
