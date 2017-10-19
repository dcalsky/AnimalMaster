package DesignPattern;

public class Main {

    public static void main(String[] args) {
	//Pig pig1 = (Pig) Pig.instance.clone();
	Pig pig = (Pig)GameObject.findAndClone("DesignPattern.Pig");
	
	System.out.println(GameObject.getNumber());
    }

}
