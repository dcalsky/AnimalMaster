package container;


public class CementType extends LayerType {

	private static CementType instance=new CementType();
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Cement";
	}

	@Override
	public Object getMaterial() {
		// TODO Auto-generated method stub
		return "Hard and gray";
	}
	public static CementType getInstance()
	{
		return instance;
	}


}