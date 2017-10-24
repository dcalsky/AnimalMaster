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
    private Fruit fruit;
    private Vegetable vegetable;

    protected void setSize(int size)
    {
        this.size=size;
    }

    public PlantContainer(int size){
        this.size = size;
        plants = new ArrayList<>();
    }

    public void addPlant(Plant plant){
        if(plants.size() == size){
            System.out.println("land is full");
        }else{
            this.plants.add(plant);
        }
    }

    public PlantContainerIterator iterator(LifeCycle lifeCycle){
        return new PlantContainerIterator(this,lifeCycle);
    }

    public void createPlantFactory(final PlantFactory pFactory){
        setFruit(pFactory.createFruit());
        setVegetable(pFactory.createVegetable());
        plants = new ArrayList<>();
    }

    public List<Plant> getPlants(){
        return plants;
    }

    public void setFruit(Fruit fruit){
        this.fruit = fruit;
    }

    public void setVegetable(Vegetable vegetable){
        this.vegetable = vegetable;
    }

    public Fruit getFruit(){
        return fruit;
    }

    public Vegetable getVegetable() {
        return vegetable;
    }
}
