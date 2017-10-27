package example;//import action.Action;
//import node.Living;
//
//import java.util.Observable;
//import java.util.Observer;
//
//public class example.FlyAction extends Observable implements Action {
//    private Observable observables;
//
//    @Override
//    public void add_observable(Observer obs) {
//        this.observables.addObserver(obs);
//    }
//
//    @Override
//    public void work() {
//        System.out.println("fly!!!");
//    }
//
//    example.FlyAction(Living living) {
//
//    }
//}


import action.Action;
import node.Node;

public class FlyAction implements Action {
    @Override
    public Node wrap(Node n) {
        System.out.println("Fly");
        return n;
    }
}