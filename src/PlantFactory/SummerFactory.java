package PlantFactory;

import PlantFactory.Fruit.Fruit;
import PlantFactory.Fruit.Melon;
import PlantFactory.Vegetable.Tomato;
import PlantFactory.Vegetable.Vegetable;

public class SummerFactory implements PlantFactory {
    @Override
    public Fruit createFruit() {
        return new Melon();
    }

    @Override
    public Vegetable createVegetable() {
        return new Tomato();
    }
}
