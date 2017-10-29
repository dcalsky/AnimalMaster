package container;

//land 地皮
public class Land extends SpaceContainer {
    public Land(){
        super(100);
    }
    protected Integer length=-1;
	protected Integer width=-1;
	public static final int MATCH_PARENT=-1;
	protected void setSize(int length,int width)
	{
		this.length=length;
		this.width=width;

	}
   
	public Integer getLength()
	{
		return length;
	}
	public Integer getWidth()
	{
		return width;
	}
	public void setLength(int length)
	{
		this.length=length;
	}
	public void setWidth(int width)
	{
		this.width=width;
	}
}
