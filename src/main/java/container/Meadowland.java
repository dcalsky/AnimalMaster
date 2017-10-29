package container;


public class Meadowland extends SpecificLand{
    @Override
    public String getMaterial()
    {
        return "Meadow Land";
    }
    @Override
    public String getType()
    {
        return "Hay";
    }
    @Override
    public Meadowland clone()
    {
        return new Meadowland();
    }
    public Meadowland(int length,int width)
    {
        super();
        this.length=length;
        this.width=width;
    }
    public Meadowland()
    {
       super();
    }
}
