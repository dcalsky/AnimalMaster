package ForTest;

import BaseClass.Plant;
import Extend.LifeCycle;
import Root.GameObject;

/**
 * Created by LSL on 2017/10/21
 */

public class Rice extends Plant
{
	private static Rice rice = new Rice();

	@Override
	public GameObject clone()
	{
		return new Rice();
	}

	private Rice()
	{
		lifePeriod = LifeCycle.SEED;
		super.addPrototype(this);
	}

	void printLifePeriod()
	{
		System.out.println(this.lifePeriod);
	}

	public void destroy()
	{
		super.destroy(this);
	}

	public static Rice Clone()
	{
		return new Rice();
	}

	public void update(){
		System.out.println("rice get Updated");
	}
}
