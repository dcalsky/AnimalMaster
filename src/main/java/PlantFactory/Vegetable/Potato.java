package PlantFactory.Vegetable;

import Extend.LifeCycle;
import Root.GameObject;

public class Potato extends Vegetable {
    private static Potato potato = new Potato();

    protected String PlantName = "Strawberry";

    @Override
    public GameObject clone()
    {
        return new Potato();
    }

    public Potato(){
        lifePeriod = LifeCycle.SEED;
        super.addPrototype(this);
    }


    void printLifePeriod()
    {
        System.out.println(this.lifePeriod);
    }

    public void destroy()
    {
        super.destroy(this);
    }

    public static Potato Clone()
    {
        return new Potato();
    }

    public void update(){
        System.out.println(this.getPlantName()+" get Updated");
    }

    @Override
    public String getPlantName() {
        return PlantName;
    }
}
