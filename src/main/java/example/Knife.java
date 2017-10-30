package example;

import node.Tool;
import node.Node;

public class Knife extends Tool {
    @Override
    public void do_action(Node node) {
        if (node instanceof Animal) {
            ((Animal) node).state.dead();
            System.out.println(((Animal) node).type + " has been killed!");
        } else {
            System.out.println("Knife can only use for animals!");
        }
    }
}
