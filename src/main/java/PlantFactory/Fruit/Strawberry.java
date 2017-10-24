package PlantFactory.Fruit;

import Extend.LifeCycle;
import Root.GameObject;

public class Strawberry extends Fruit
{
    private static Strawberry strawberry = new Strawberry();

    protected String PlantName = "Strawberry";

    @Override
    public GameObject clone()
    {
        return new Strawberry();
    }

    public Strawberry(){
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

    public static Strawberry Clone()
    {
        return new Strawberry();
    }

    public void update(){
        System.out.println(this.getPlantName()+" get Updated");
    }

    @Override
    public String getPlantName() {
        return PlantName;
    }
}
