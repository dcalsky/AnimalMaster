package ForTest;

import BaseClass.Animal;
import Root.GameObject;

public final class Pig extends Animal
{
    public static Pig instance = new Pig();

    @Override
    public GameObject clone()
    {
		return new Pig();
    }
    
    public void destroy(){
	super.destroy(this);
    }
    
    private Pig()
    {
    	super.addPrototype(this);
    }
    
    public static Pig Clone()
    {
		return new Pig();
    }

    @Override
    public void update() {
        System.out.println("Pig learned ");
    }
}

