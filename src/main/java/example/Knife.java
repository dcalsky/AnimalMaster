package example;

import node.Equipment;
import node.Node;

public class Knife extends Equipment {
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
