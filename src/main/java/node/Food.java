package node;

import java.util.HashMap;

public class Food extends Node {
    private static int count = 0;
    private static HashMap<String, Food> tags = new HashMap<String, Food>();
    private String tag;
    protected String name;

    protected Food(String tag) {
        this.name = tag;
        if (tags.containsKey(tag)) {
            throw new Error("This tag have been occupied");
        } else {
            tags.put(tag, this);
            Food.count += 1;
        }

    }

    protected Food() {
        this.name = null;
        this.tag = "Food" + Integer.toString(get_count());
        Food.count += 1;
    }

    public static Food create() {
        return new Food("Food" + Integer.toString(get_count()));
    }

    public static Food create(String tag) {

        return new Food(tag);
    }

    public static int get_count() {
        return Food.count;
    }

    public static Food find(String tag) {
        return Food.tags.get(tag);
    }

    public void destroy() {
        Food.tags.remove(this.tag);
    }

    public String set_tag(String new_tag) {
        this.tag = new_tag;
        return this.tag;
    }

    public String get_tag() {
        return tag;
    }

    public String getName(){
        return name;
    }



    protected void beDecorated(){
        //System.out.println("i cook it");
    };





}
