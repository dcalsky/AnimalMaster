package example;

import node.Food;
import node.FoodDecorator;

public class RoastFood extends FoodDecorator {
    public RoastFood(Food food){
        super(food);
    }

    @Override
    public String getName(){
        beDecorated();
        return ("roast " + food.getName());
    }

    @Override
    public void beDecorated(){
        System.out.println("i roasted it");
    }

    public static void main(String args[]){
        Food c1 = Food.create("chicken");
        System.out.println(c1.getName());
        RoastFood roastFood = new RoastFood(c1);
        System.out.println(roastFood.getName());

    }


}
