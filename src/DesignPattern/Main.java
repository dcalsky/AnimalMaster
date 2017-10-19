package DesignPattern;

public class Main {

    public static void main(String[] args) {
<<<<<<< HEAD
	Pig pig1 = Pig.Clone();
	Pig pig = (Pig)GameObject.findAndClone("DesignPattern.Pig");
	
	System.out.println(GameObject.getNumber());
	System.out.println(Animal.getNumber());
	// 使用
=======
	//Pig pig1 = (Pig) Pig.instance.clone();
	Pig pig = (Pig)GameObject.findAndClone("DesignPattern.Pig");
	
	System.out.println(GameObject.getNumber());
>>>>>>> ddf9484... First
    }

}
