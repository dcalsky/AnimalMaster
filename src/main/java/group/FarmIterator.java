package group;

import action.Action;
import node.Node;
import state.LivingState;

import java.util.List;
public class FarmIterator<T> implements Iterator {
    private List<T> objs;
    private LivingState state;
    private int idx;


    public FarmIterator(List<T> objs){
        this.objs = objs;
        idx = -1;
    }

    @Override
    public T next() {
        idx = findNextIdx();
        if (idx != -1) {
            return objs.get(idx);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return findNextIdx() != -1;
    }

    private int findNextIdx(){
        boolean isFind = false;
        int tempIndex = idx;
        while (!isFind){
            tempIndex++;
            if (tempIndex >= objs.size()){
                tempIndex = -1;
                break;
            }
            if (nextFliter())break;
        }
        return tempIndex;
    }

    private boolean nextFliter(){
        //由客户决定迭代器寻找下一个元素的条件
        return true;
    }

    private void resetIdx(){
        idx = -1;
    }

    public void allDoAction(Action action){
        resetIdx();
        if (objs.isEmpty()){
            System.out.println("Group is null!");
            return;
        }
        while (hasNext()){
            Node next = (Node)next();
            action.wrap(next);
        }
    }

}
