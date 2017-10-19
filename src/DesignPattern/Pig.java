package DesignPattern;

public class Pig extends Animal{
    public static Pig instance;
    @Override
    public GameObject clone() {
	return new Pig();
    }
    
    public void destroy(){
	super.destroy(this);
    }
    
    private Pig(){
	super.addPrototype(this);
    }
}
