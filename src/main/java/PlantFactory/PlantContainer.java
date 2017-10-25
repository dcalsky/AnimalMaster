package PlantFactory;

/****
 *
 * 存放植物实例的容器
 *
 * Created by VentusXu on 2017/10/23
 *
 */

import BaseClass.Plant;
import Extend.LifeCycle;
import PlantFactory.Fruit.Fruit;
import PlantFactory.Vegetable.Vegetable;


import java.util.ArrayList;
import java.util.List;

public class PlantContainer{
    private List<Plant> plants;
    private int size;
    private Plant plant;

    protected void setSize(int size)
    {
        this.size=size;
    }

    public PlantContainer(int size){
        this.size = size;
        plants = new ArrayList<>();
    }

    public void addPlant(){
        if(plants.size() == size){
            System.out.println("land is full");
        }else{
            plants.add(plant);
        }
    }

    public PlantContainerIterator iterator(LifeCycle lifeCycle){
        return new PlantContainerIterator(this,lifeCycle);
    }

    public void createPlantFactory(final PlantFactory pFactory){
        setPlant(pFactory.createPlant());
        plants = new ArrayList<>();
    }

    public List<Plant> getPlants(){
        return plants;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public Plant getPlant() {
        return plant;
    }
}
