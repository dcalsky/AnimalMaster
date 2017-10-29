package container;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public  class SpecificLand extends Land {
	private LayerType type;
	public LayerType getType()
	{
		return type;
	}
	public void setLayertype(LayerType type) {
		this.type=type;
	}
	
    public SpecificLand(Integer length,Integer width,LayerType type) {
    	this.type=type;
    	this.length=length;
    	this.width=width;
    	
    }
    public SpecificLand(LayerType type) {
    	this.type=type;
    	
    	
    }
    
    
}
