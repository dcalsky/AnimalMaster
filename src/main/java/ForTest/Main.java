package ForTest;

import ActionBase.Action;
import BaseClass.Animal;
import BaseClass.Equipment;
import BaseClass.Farm;
import Extend.LifeCycle;
import Root.GameObject;


/*
	这个Package不是框架里应该有的东西，在开发阶段用于简单的测试
 */

public class Main {

    static Walk walk = new Walk("walk");
    static Jump jump = new Jump("jump");
    public static void main(String[] args) {

	    Farm myFarm = Farm.getInstance();
	    /* 农场对象初始化，初始化后findAndClone可以直接使用 */
	    myFarm.initialize();

		Pig pig = (Pig) GameObject.findAndClone(Pig.class);
		System.out.println(pig.getClass().getSuperclass());



		//Rice rice = Rice.Clone();
		Rice rice1 = (Rice) GameObject.findAndClone(Rice.class);
		rice1.setLifePeriod(LifeCycle.BUD);
		rice1.printLifePeriod();


		// 使用

	    //Sty sty1 = Sty.Clone();
	    //Sty sty2 = (Sty) GameObject.findAndClone("ForTest.Sty");

	    System.out.println("game: " + GameObject.getNumber());
	    System.out.println("animal: " + Animal.getNumber());
	    System.out.println("equip: " + Equipment.getNumber());
	    System.out.println("sty: " + Sty.getNumber());

            ////////////////////////////////////////////////////////////////////
            
            Action animalWalk = Action.findAndClone("ForTest.Walk");
            Action animalJump = Action.findAndClone("ForTest.Jump");
            Action.showContent();
            
            pig.setAction(animalJump);
            pig.setAction(animalWalk);
            rice1.setAction(animalWalk);
            
            //pig.deleteAction(animalJump);
            rice1.deleteAction(animalJump);

    }

}
