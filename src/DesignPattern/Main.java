package DesignPattern;

public class Main {

    public static void main(String[] args) {
	Pig pig1 = Pig.Clone();
	Pig pig = (Pig)GameObject.findAndClone("DesignPattern.Pig");
	
	System.out.println(GameObject.getNumber());
	System.out.println(Animal.getNumber());
    }

}
