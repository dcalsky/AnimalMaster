package example;

import node.Node;

//继承自node类的自定义装备类
public class Equipment extends Node
{
	//描述这个装备的类型
	private String equipType;

	//穿戴这件装备的animal
	private Animal  dresser;

	public void setEquipType(String equipType)
	{
		this.equipType = equipType;
	}

	public String getEquipType()
	{
		return equipType;
	}
	Equipment(String type)
	{
		equipType = type;
	}

	public void setDresser(Animal dresser)
	{
		this.dresser = dresser;
	}

	public void printStatus()
	{
		System.out.println( equipType+"(ID:"+this.getID()+")" + "is dressed by "+ dresser.type+"(ID:"+dresser.getID()+")");
	}
}
