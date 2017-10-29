package node;

public class FoodDecorator extends Food {
    protected Food food;

    public FoodDecorator(Food food){
        this.food = food;
    }
    @Override
    public String getName(){
        beDecorated();
        return food.name;
    }

    @Override
    public void beDecorated(){
        System.out.println("i cook it");
    }


}
