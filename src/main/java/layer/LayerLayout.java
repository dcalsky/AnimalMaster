package layer;

import java.util.List;

import land.Land;

public interface LayerLayout<T> {
	public List<T> getallAreas();
	public T setArea(T area,int location);
	public T getArea(int location);
	public void regulate(int length,int width);

}
