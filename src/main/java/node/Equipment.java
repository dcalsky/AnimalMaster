package node;

import java.util.HashMap;


/*
* command pattern
* */
public abstract class Equipment extends Node {
    private static int count = 0;
    private static HashMap<String, Equipment> tags = new HashMap<String, Equipment>();
    private String tag;

    protected Equipment(String tag) {
        if (tags.containsKey(tag)) {
            throw new Error("This tag have been occupied");
        } else {
            tags.put(tag, this);
            Equipment.count += 1;
            this.tag = tag;
        }
    }

    protected Equipment() {
        this.tag = "Equipment" + Integer.toString(get_count());
        tags.put(this.tag, this);
        Equipment.count += 1;
    }

    public abstract void do_action(Node node);
}
