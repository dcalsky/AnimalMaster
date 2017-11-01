package sample;


import action.Action;
import sample.Animal;
import node.Node;

public class SwimAction implements Action {
    @Override
    public Node wrap(Node n) {
        if (n instanceof Animal) {
            System.out.print("I'm an animal so I can: ");
        }
        System.out.println("Swim");
        return n;
    }
}