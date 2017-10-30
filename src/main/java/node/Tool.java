package node;

import java.util.HashMap;


/*
* command pattern
* */
public abstract class Tool extends Node {
    private static int count = 0;
    private static HashMap<String, Tool> tags = new HashMap<String, Tool>();
    private String tag;

    protected Tool(String tag) {
        if (tags.containsKey(tag)) {
            throw new Error("This tag have been occupied");
        } else {
            tags.put(tag, this);
            Tool.count += 1;
            this.tag = tag;
        }
    }

    protected Tool() {
        this.tag = "Equipment" + Integer.toString(get_count());
        tags.put(this.tag, this);
        Tool.count += 1;
    }

    public abstract void do_action(Node node);
}
