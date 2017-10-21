package DesignPattern;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class GameObject {
    private static List<GameObject> gameObjects = new ArrayList<>();
    
    protected abstract GameObject clone();
    
    public static GameObject findAndClone(String type){
		for(GameObject go : gameObjects){
			if(go.getClass().getName().equals(type))
			return go.clone();
		}
		return null;
    }
    
    protected void addPrototype(GameObject gameObject){
	gameObjects.add(gameObject);
    }
    
    protected void destroy(GameObject go){
	gameObjects.remove(go);
    }
    
    public static int getNumber(){
		Set<String> set = new HashSet<>();
		for(GameObject go : gameObjects){
			set.add(go.getClass().getName());
		}
		return gameObjects.size() - set.size();
    }
    
}
