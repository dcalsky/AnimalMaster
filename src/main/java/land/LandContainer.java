package land;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import land.specificLands.CementLand;
import land.specificLands.Meadowland;
import layer.LayerLayout;
import layer.layout.BorderLayout;
import layer.layout.FlowLayout;
import space.SpecificLand;

public class LandContainer extends Land{
	
	private static List<LandContainer> objs = new ArrayList<>();
	private LayerLayout<Land> layout;

    //每有一个新的类继承GameObject或者任何一个GameObeject的子类，除非这个类是final类型，否则需要为他添加private static的list
    
    public LandContainer()
	{
    	layout=new FlowLayout(FlowLayout.HORIZONTAL);

	}

    protected void addPrototype (LandContainer landContainer) {
    	super.addPrototype(landContainer);
    	objs.add(landContainer);
    }
    //所有非final类都需要重载addPrototype方法，实现方法是super.addPrototype(参数);list.add(参数);
    
    public static int getNumber()
    {
		Set<String> set = new HashSet<>();
		for(LandContainer landContainer : objs)
		{
	        set.add(landContainer.getClass().getName());
		}
		System.out.println("objs: " + objs.size());
	    System.out.println("set: " + set.size());
		return objs.size() - set.size();
    }
    //所有非final类需要实现public static的getNumber
    
    protected void destroy(LandContainer landContainer){
    	super.destroy(landContainer);
    	objs.remove(landContainer);
    }
    //所有继承类需要重载destroy
    public void add(Land land,int location) {
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
	public void add(Land land) {
    	if(layout instanceof FlowLayout)
		{
			layout.setArea(land, layout.getallAreas().size());
		}

	}
	protected Land get(int location) {

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
					result=result+((SpecificLand) areas.get(i)).getMaterial()+" length:"+areas.get(i).getLength()+" width:"+ areas.get(i).getWidth()+"    ";
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
					result=result+((SpecificLand) areas.get(i)).getMaterial()+" length:"+areas.get(i).getLength()+" width:"+ areas.get(i).getWidth()+"    ";
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
		center.add(new Meadowland(200,100));
		center.add(new CementLand(Land.MATCH_PARENT,Land.MATCH_PARENT));
		center.add(new Meadowland(Land.MATCH_PARENT,Land.MATCH_PARENT));
		farm.add(center,BorderLayout.Center);
		farm.add(new CementLand(),BorderLayout.East);
		farm.add(new CementLand(),BorderLayout.West);
		farm.add(new CementLand(),BorderLayout.North);
		farm.add(new CementLand(),BorderLayout.South);
		System.out.println(farm);

	}


}
