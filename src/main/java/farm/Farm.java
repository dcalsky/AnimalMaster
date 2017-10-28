package farm;


import node.Node;

import java.util.ArrayList;
import java.util.List;

/*
 * Singleton and Strategy Methoed
 */
public class Farm {
    private static Farm farmInstance = null;
    private static List<Node> objs = new ArrayList<>();

    private FarmLevel level;

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
        this.level = new BaseFarmLevel();
    }

    public void rebuild(FarmLevel new_level) {
        this.level = new_level;
    }

    public void expand() {
        this.level.expand();
    }

    public void shrink() {
        this.level.shrink();
    }

    public void add(Node node) {
        if (this.level.get_capacity() < Farm.objs.size()) {
            Farm.objs.add(node);
        } else {
            throw new Error("Farm capacity reaches upper limitation!");
        }
    }

    public static int getNumber() {
        return Farm.objs.size();
    }
}