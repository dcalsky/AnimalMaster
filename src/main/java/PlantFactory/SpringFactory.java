package PlantFactory;

import PlantFactory.Fruit.Fruit;
import PlantFactory.Fruit.Strawberry;
import PlantFactory.Vegetable.Potato;
import PlantFactory.Vegetable.Vegetable;

public class SpringFactory implements PlantFactory{
    @Override
    public Fruit createFruit() {
        return new Strawberry();
    }

    @Override
    public Vegetable createVegetable() {
        return new Potato();
    }
}
