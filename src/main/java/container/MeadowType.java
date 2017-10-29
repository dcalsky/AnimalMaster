package container;

public class MeadowType extends LayerType {
	private static MeadowType instance=new MeadowType();
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Hay";
	}

	@Override
	public Object getMaterial() {
		// TODO Auto-generated method stub
		return "Soft and Yellow";
	}
	public static MeadowType getInstance()
	{
		return instance;
	}

	
}
