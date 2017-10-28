package example;

/*
 * Adapter method for animal evolution
 */
public class Adapter extends Animal{
    private AfterEvolution ae;
    public Adapter(AfterEvolution ae) {
        this.ae = ae;
    }

    public void speak() {
        ae.introduce();
        ae.intelligence();
    }
}
