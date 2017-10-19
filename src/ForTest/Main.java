package ForTest;

import BaseClass.Animal;
import Root.GameObject;


/*
	这个Package不是框架里应该有的东西，在开发阶段用于简单的测试
 */

public class Main {

    public static void main(String[] args) {
	Pig pig1 = Pig.Clone();
	Pig pig = (Pig) GameObject.findAndClone("Pig");
	
	System.out.println(GameObject.getNumber());
	System.out.println(Animal.getNumber());
	// 使用
    }

}
