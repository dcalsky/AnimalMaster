package Root;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class GameObject {
	//
    private static List<GameObject> objects = new ArrayList<>();
    
    protected abstract GameObject clone();
    
    public static GameObject findAndClone(String type){
		for(GameObject go : objects){
		    if(go.getClass().getName().equals(type))
			return go.clone();
		}
		return null;
    }
    
    protected void addPrototype(GameObject gameObject)
    {
		objects.add(gameObject);
    }
    
    protected void destroy(GameObject go)
    {
    	System.out.println(super.getClass().getName());
		objects.remove(go);
    }
    
    public static int getNumber(){
		Set<String> set = new HashSet<>();
		for(GameObject go : objects){
		    set.add(go.getClass().getName());
		}
		return objects.size() - set.size();
    }
    
}
