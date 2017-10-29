package example;

import container.Building;

public class TestBuilding {
    public static void main(String[] args) {
        Building building = new Building();
        building.addAcceptableClass(Animal.class);
        try {
            building.add(new Animal());
            System.out.println();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
