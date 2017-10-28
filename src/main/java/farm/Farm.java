package farm;


import node.Node;

import java.util.ArrayList;
import java.util.List;

/*
 * Singleton, Strategy Memento Methods
 */
public class Farm {
    private static Farm farmInstance = null;
    private static List<Node> objs = new ArrayList<>();

    private static FarmLevel level;

    public static Farm getInstance() {
        try {
            if (farmInstance != null) {
                //直接返回
            } else {
                // 避免多线程下重复创建单例，为单例加锁（DCL）
                synchronized (Farm.class) {
                    Thread.sleep(300);
                    if (farmInstance == null)    //二次检查
                    {
                        farmInstance = new Farm();
                    }
                }
            }
        } catch (InterruptedException error) {
            error.printStackTrace();
        }
        return farmInstance;
    }

    private Farm() {
        level = new BaseFarmLevel();
    }

    public void rebuild(FarmLevel new_level) {
        level = new_level;
    }

    public void expand() {
        level.expand();
    }

    public void shrink() {
        level.shrink();
    }

    public FarmLevel get_level() {
        return level;
    }

    public List<Node> get_objs() {
        return objs;
    }

    public void restore(FarmMemento memento) {
        level = memento.get_level();
        objs = memento.get_objs();
    }

    public void add(Node node) {
        if (level.get_capacity() > Farm.objs.size()) {
            Farm.objs.add(node);
        } else {
            throw new Error("Farm capacity reaches upper limitation!");
        }
    }

    public int getNumber() {
        return Farm.objs.size();
    }
}