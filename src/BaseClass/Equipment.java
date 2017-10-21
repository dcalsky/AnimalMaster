package BaseClass;

import Root.GameObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The base class of the equipments that are used to equip animals
 *
 * Created by LSL on 2017/10/19
 */

public abstract class Equipment extends GameObject
{
	private static List<Equipment> equips = new ArrayList<>();
	//每有一个新的类继承GameObject或者任何一个GameObeject的子类，除非这个类是final类型，否则需要为他添加private static的list

	protected Equipment() { }

	protected void addPrototype(Equipment equip) {
		super.addPrototype(equip);
		equips.add(equip);

	}
	//所有非final类都需要重载addPrototype方法，实现方法是super.addPrototype(参数);list.add(参数);

	public static int getNumber()
	{
		//用set把原型prototype去掉，统计的是实际产生的object
		Set<String> set = new HashSet<>();
		for(Equipment go : equips){
			set.add(go.getClass().getName());
		}
		return equips.size() - set.size();
	}
	//所有非final类需要实现public static的getNumber

	protected void destroy(Equipment equip){
		super.destroy(equip);
		equips.remove(equip);

	}
	//所有继承类需要重载destroy


}
