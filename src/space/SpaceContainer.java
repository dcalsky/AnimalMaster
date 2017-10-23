package space;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class SpaceContainer extends SpaceHolder {
	private static List<SpaceContainer> objs = new ArrayList<>();
    //每有一个新的类继承GameObject或者任何一个GameObeject的子类，除非这个类是final类型，否则需要为他添加private static的list
    private ArrayList<SpaceHolder> spaceHolders;
    protected SpaceContainer() { }
    protected void addPrototype (SpaceContainer spaceContainer) {
    	super.addPrototype(spaceContainer);
    	objs.add(spaceContainer);
    }
    //所有非final类都需要重载addPrototype方法，实现方法是super.addPrototype(参数);list.add(参数);
    protected boolean add(SpaceHolder spaceHolder) {
    	if(checkSpaceconflict(spaceHolder))
    	{
    		spaceHolders.add(spaceHolder);
    		return true;
    	}
    	else
    	{
    		return false;
    	}
		
	}
    protected abstract boolean checkSpaceconflict(SpaceHolder spaceHolder);
    public static int getNumber()
    {
		Set<String> set = new HashSet<>();
		for(SpaceContainer spaceContainer : objs)
		{
	        set.add(spaceContainer.getClass().getName());
		}
		System.out.println("objs: " + objs.size());
	    System.out.println("set: " + set.size());
		return objs.size() - set.size();
    }
    //所有非final类需要实现public static的getNumber
    
    protected void destroy(SpaceContainer spaceContainer){
    	super.destroy(spaceContainer);
    	objs.remove(spaceContainer);
    }
    //所有继承类需要重载destroy
    
    


}
