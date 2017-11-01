package sample;

import sample.AfterEvolution;
import sample.Animal;

/*
 * Adapter method for animal evolution
 */
public class Adapter extends Animal {
    private AfterEvolution ae;

    public Adapter(AfterEvolution ae) {
        this.ae = ae;
    }

    public void jump() {
        ae.introduce();
        ae.intelligence();
    }
}
