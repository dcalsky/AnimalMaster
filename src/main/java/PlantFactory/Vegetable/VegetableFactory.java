package PlantFactory.Vegetable;

import BaseClass.Plant;
import PlantFactory.PlantFactory;
import Root.GameObject;

public class VegetableFactory implements PlantFactory{
    private Class name;

    public VegetableFactory(Class name){
        this.name = name;
    }

    public Plant createPlant(){
        return (Vegetable) GameObject.findAndClone(name);
    }
}
