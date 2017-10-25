package ForTest;

import Extend.LifeCycle;
import PlantFactory.Fruit.Fruit;
import Root.GameObject;

public class Melon extends Fruit {

    private static Melon melon = new Melon();

    protected String PlantName = "Melon";

    @Override
    public GameObject clone()
    {
        return new Melon();
    }

    public Melon(){
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

    public static Melon Clone()
    {
        return new Melon();
    }

    public void update(String actionName){
        System.out.println(this.getPlantName()+" get Updated");
    }

    public String getPlantName() {
        return PlantName;
    }

}
