package example;

import node.Food;
import node.FoodDecorator;

public class RoastFood extends FoodDecorator {
    public RoastFood(Food food) {
        super(food);
    }

    @Override
    public String getName() {
        beDecorated();
        return ("roast " + food.getName());
    }

    @Override
    public void beDecorated() {
        System.out.println("i roasted it");
    }
}
