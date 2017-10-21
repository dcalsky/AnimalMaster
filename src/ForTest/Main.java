package ForTest;

import BaseClass.Animal;
import BaseClass.Equipment;
import Extend.LifeCycle;
import Root.GameObject;


/*
	这个Package不是框架里应该有的东西，在开发阶段用于简单的测试
 */

public class Main {

    public static void main(String[] args) {
		//Pig pig1 = Pig.Clone();
		Pig pig2 = Pig.Clone();
		Pig pig = (Pig) GameObject.findAndClone("ForTest.Pig");
		System.out.println(pig.getClass().getSuperclass());

		Rice rice = Rice.Clone();
		Rice rice1 = (Rice)GameObject.findAndClone("ForTest.Rice");
		rice1.setLifePeriod(LifeCycle.BUD);
		rice1.printLifePeriod();
		rice.printLifePeriod();

		// 使用

	    //Sty sty1 = Sty.Clone();
	    //Sty sty2 = (Sty) GameObject.findAndClone("ForTest.Sty");

	    System.out.println("game: " + GameObject.getNumber());
	    System.out.println("animal: " + Animal.getNumber());
	    System.out.println("equip: " + Equipment.getNumber());
	    System.out.println("sty: " + Sty.getNumber());
    }

}
