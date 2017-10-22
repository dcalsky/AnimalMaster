package BaseClass;

import ActionBase.Action;
import Extend.LifeCycle;
import Root.GameObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by LSL on 2017/10/20
 */

public abstract class Plant extends GameObject
{
	private static List<Plant> plants = new ArrayList<>();

	protected Plant() { }

	protected LifeCycle lifePeriod;

	protected void addPrototype(Plant plant)
	{
		super.addPrototype(plant);
		plants.add(plant);

	}

	public void setLifePeriod(LifeCycle lifePeriod)
	{
		this.lifePeriod = lifePeriod;
	}

	public static int getNumber()
	{
		//用set把原型prototype去掉，统计的是实际产生的object
		Set<String> set = new HashSet<>();
		for(Plant go : plants){
			set.add(go.getClass().getName());
		}
		return plants.size() - set.size();
	}


	protected void destroy(Plant plant){
		super.destroy(plant);
		plants.remove(plant);

	}
        
        public void setAction(Action action){
        //System.out.println(action.getClass().getName()+" "+this.getClass().getName());
        action.attach(action, this);
        }
        
        public void deleteAction(Action action){
         action.dettach(action,this);
     }

}
