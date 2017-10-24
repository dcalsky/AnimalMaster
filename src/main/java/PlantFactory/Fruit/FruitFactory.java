package PlantFactory.Fruit;

import BaseClass.Plant;
import PlantFactory.PlantFactory;
import Root.GameObject;

public class FruitFactory implements PlantFactory{
    private Class name;

    public FruitFactory(Class name){
        this.name = name;
    }

    public Plant createPlant(){
        return (Fruit) GameObject.findAndClone(name);
    }
}
