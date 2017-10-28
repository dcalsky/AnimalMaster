package example;


import action.Action;
import node.Node;

public class FlyAction implements Action {
    @Override
    public Node wrap(Node n) {
        if (n instanceof Animal) {
            System.out.print("I'm an animal so I can: ");
        }
        System.out.println("Fly");
        return n;
    }
}