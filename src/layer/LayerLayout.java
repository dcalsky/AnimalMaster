package layer;

import java.util.List;

import land.Land;

public interface LayerLayout {
	public List<String> getallAreas();
	public boolean setLayout(Land land,int location);

}
