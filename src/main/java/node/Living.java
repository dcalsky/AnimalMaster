package node;

import Group.Group;

import java.util.HashMap;

public class Living extends Node {
    private static int count = 0;
    private static HashMap<String, Living> tags = new HashMap<String, Living>();
    private String tag;

    protected Living(String tag) {
        if (tags.containsKey(tag)) {
            throw new Error("This tag have been occupied");
        } else {
            tags.put(tag, this);
            Living.count += 1;
            this.tag = tag;
        }
    }

    protected Living() {
        this.tag = "Living" + Integer.toString(get_count());
        tags.put(this.tag, this);
        Living.count += 1;
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
        Living.tags.remove(this.tag);
    }

    public String set_tag(String new_tag) {
        this.tag = new_tag;
        return this.tag;
    }

    public void act(){
        System.out.println("i can do noting");
    };
    public void unact(){

    }

    public String get_tag() {
        return tag;
    }





}
