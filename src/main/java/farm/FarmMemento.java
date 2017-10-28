package farm;

import node.Node;

import java.util.ArrayList;
import java.util.List;

public class FarmMemento {
    private FarmLevel level;
    private List<Node> objs;

    public FarmMemento(Farm farm) {
        this.level = farm.get_level();
        this.objs = farm.get_objs();
    }

    public FarmMemento get_state() {
        return this;
    }

    public FarmLevel get_level() {
        return level;
    }

    public List<Node> get_objs() {
        return objs;
    }
}
