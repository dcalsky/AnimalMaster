package example;

import container.*;

import java.util.ArrayList;
import java.util.List;


public class LandContainer extends Land {
	
	private static List<LandContainer> objs = new ArrayList<>();
	private LayerLayout<Land> layout;

    //每有一个新的类继承GameObject或者任何一个GameObeject的子类，除非这个类是final类型，否则需要为他添加private static的list
    
    public LandContainer()
	{
    	layout=new FlowLayout(FlowLayout.HORIZONTAL);

	}

    //所有继承类需要重载destroy
    public void addland(Land land,int location) {
    	/*if(land.getLength()==Land.MATCH_PARENT)
		{
			land.setLength(this.length);
		}
		if(land.getWidth()==Land.MATCH_PARENT)
		{
			land.setWidth(this.width);
		}*/
		layout.setArea(land, location);
		regulate();

	}
	public void addland(Land land) {
    	if(layout instanceof FlowLayout)
		{
			layout.setArea(land, layout.getallAreas().size());
		}

	}
	protected Land getland(int location) {

    	return layout.getArea(location);

	}
	@Override
	public LandContainer clone()
	{
		return new LandContainer();
	}


	public void setLayout(LayerLayout<Land> layout) {
		this.layout = layout;
	}
	public LayerLayout<Land> getLayout()
	{
		return layout;
	}

	@Override
	public String toString()
	{	String result="(";
		List<Land> areas=layout.getallAreas();
		if(layout instanceof FlowLayout)
		{

			for(int i=0;i<areas.size();i++)
			{
				if(areas.get(i) instanceof LandContainer)
				{
					result=result+areas.get(i).toString()+" length:"+areas.get(i).getLength()+" width:"+ areas.get(i).getWidth()+"    ";
				}
				else if(areas.get(i) instanceof SpecificLand)
				{
					result=result+((SpecificLand) areas.get(i)).getType().getMaterial()+" length:"+areas.get(i).getLength()+" width:"+ areas.get(i).getWidth()+"    ";
				}
			}
		}
		else
		{

			for (int i=0;i<areas.size();i++)
			{
				switch (i)
				{
					case 0: result=result+"center:";
							break;
					case 1: result=result+"South:";
							break;
					case 2: result=result+"North:";
							break;
					case 3: result=result+"East:";
							break;
					case 4: result=result+"West:";
							break;

				}
				if(areas.get(i) instanceof LandContainer)
				{
					result=result+areas.get(i).toString()+" length:"+areas.get(i).getLength()+" width:"+ areas.get(i).getWidth()+"    ";
				}
				else if(areas.get(i) instanceof SpecificLand)
				{
					result=result+((SpecificLand) areas.get(i)).getType().getMaterial()+" length:"+areas.get(i).getLength()+" width:"+ areas.get(i).getWidth()+"    ";
				}
			}
		}
		return result+")";
	}
	public void regulate()
	{
		layout.regulate(this.length,this.width);
	}
	public static void main(String[] args)
	{
		LandContainer farm=new LandContainer();
		farm.setLength(1500);
		farm.setWidth(1000);
		farm.setLayout(new BorderLayout());
		LandContainer center=new LandContainer();
		center.addland(new SpecificLand(200,100,CementType.getInstance()));
		center.addland(new SpecificLand(Land.MATCH_PARENT,Land.MATCH_PARENT,CementType.getInstance()));
		center.addland(new SpecificLand(Land.MATCH_PARENT,Land.MATCH_PARENT,MeadowType.getInstance()));
		farm.addland(center,BorderLayout.Center);
		farm.addland(new SpecificLand(CementType.getInstance()),BorderLayout.East);
		farm.addland(new SpecificLand(CementType.getInstance()),BorderLayout.West);
		farm.addland(new SpecificLand(CementType.getInstance()),BorderLayout.North);
		farm.addland(new SpecificLand(CementType.getInstance()),BorderLayout.South);
		System.out.println(farm);

	}


}
