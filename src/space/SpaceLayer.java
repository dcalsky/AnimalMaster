package space;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import layer.LayerType;

public abstract class SpaceLayer extends SpaceHolder {

	private static List<SpaceLayer> objs = new ArrayList<>();
    //每有一个新的类继承GameObject或者任何一个GameObeject的子类，除非这个类是final类型，否则需要为他添加private static的list
    protected LayerType layerType;
    protected SpaceLayer() { height=0; }

    protected void addPrototype (SpaceLayer spaceLayer) {
    	super.addPrototype(spaceLayer);
    	objs.add(spaceLayer);
    }
    //所有非final类都需要重载addPrototype方法，实现方法是super.addPrototype(参数);list.add(参数);
    
    public static int getNumber()
    {
		Set<String> set = new HashSet();
		for(SpaceLayer spaceLayer : objs)
		{
	        set.add(spaceLayer.getClass().getName());
		}
		System.out.println("objs: " + objs.size());
	    System.out.println("set: " + set.size());
		return objs.size() - set.size();
    }
    //所有非final类需要实现public static的getNumber
    
    protected void destroy(SpaceLayer spaceLayer){
    	super.destroy(spaceLayer);
    	objs.remove(spaceLayer);
    }
    //所有继承类需要重载destroy
    
    protected void setLayerType(LayerType layerType) {
    	this.layerType=layerType;
	}
    protected LayerType setLayerType() {
    	return layerType;
	}
}
