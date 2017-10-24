package ForTest;

import BaseClass.Equipment;
import Root.GameObject;

/**
 * Created by LSL on 2017/10/20
 */
public class Sty extends Equipment
{
	@Override
	public GameObject clone()
	{
		return new Sty();
	}
	public static Sty Clone()
	{
		return new Sty();
	}

	Sty()
	{
		super.addPrototype(this);
	}

	public void destroy(){
		super.destroy(this);
	}

}
