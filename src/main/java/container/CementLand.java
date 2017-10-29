package container;



public class CementLand extends SpecificLand {
    @Override
    public String getMaterial()
    {
        return "Cement Land";
    }
    @Override
    public String getType()
    {
        return "Cement";
    }
    @Override
    public CementLand clone()
    {
        return new CementLand();
    }
    public CementLand(int length,int width)
    {
        super();
        this.length=length;
        this.width=width;
    }
    public CementLand()
    {
        super();
    }

}
