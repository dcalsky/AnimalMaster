package node;

import action.Action;
import state.DefaultLivingState;
import state.LivingState;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;


/*
 * State and Factory method
 */
public class Living extends Node {
    private static int count = 0;
    private static HashMap<String, Living> tags = new HashMap<String, Living>();
    private String tag;
    private String LivingType;
    private LivingState state = new DefaultLivingState(this);

    protected Living(String tag) {
        if (tags.containsKey(tag)) {
            throw new Error("This tag have been occupied");
        } else {
            tags.put(tag, this);
            Living.count += 1;
            this.tag = tag;
            this.state.born();
        }
    }


    protected Living() {
        this.state.born();
        this.tag = "Living" + Integer.toString(get_count());
        tags.put(this.tag, this);
        Living.count += 1;
    }

    public void do_action(Action action) {
        action.wrap(this);
    }

    public static Living create() {
        return new Living("Living" + Integer.toString(get_count()));
    }

    public static Living create(String tag) {
        return new Living(tag);
    }


    public static int get_count() {
        return Living.count;
    }

    public static Living find(String tag) {
        return Living.tags.get(tag);
    }

    public void destroy() {
        this.state.dead();
        Living.tags.remove(this.tag);
    }

    public String set_tag(String new_tag) {
        this.tag = new_tag;
        return this.tag;
    }

    public String get_tag() {
        return tag;
    }

    public void set_state(LivingState s) {
        this.state = s;
    }
}
