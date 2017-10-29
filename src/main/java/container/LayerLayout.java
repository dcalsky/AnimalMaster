package container;

import java.util.List;


public interface LayerLayout<T> {
	public List<T> getallAreas();
	public T setArea(T area,int location);
	public T getArea(int location);
	public void regulate(int length,int width);

}
