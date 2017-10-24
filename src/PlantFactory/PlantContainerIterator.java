package PlantFactory;

/****
 *
 * 实现iterator用于遍历plantcontainer中的植物
 *
 * Created by VentusXu on 2017/10/23
 *
 */

import BaseClass.Plant;
import Extend.LifeCycle;

import java.util.List;

public class PlantContainerIterator implements PlantIterator {
    private PlantContainer plantContainer;
    private LifeCycle lifeCycle;
    private int idx;

    public PlantContainerIterator(PlantContainer plantContainer, LifeCycle lifeCycle){
        this.idx = -1;
        this.plantContainer = plantContainer;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public boolean hasNext() {
        return findNextIdx() != -1;
    }

    @Override
    public Plant next() {
        idx = findNextIdx();
        if (idx != -1){
            return plantContainer.getPlants().get(idx);
        }
        return null;
    }

    private int findNextIdx(){
        List<Plant> plants = plantContainer.getPlants();
        boolean isFind = false;

        int tempIdx = idx;

        while (!isFind){
            tempIdx++;
            if (tempIdx >= plants.size()){
                tempIdx = -1;
                break;
            }
            if(lifeCycle.equals(LifeCycle.ANY) || plants.get(tempIdx).getLifePeriod().equals(lifeCycle)){
                break;
            }
        }
        return tempIdx;
    }

    private void resetIterator(){ idx = -1; }

    public void loopFromBegin(){
        resetIterator();
        while(hasNext()){
            System.out.println(next().toString());
        }
    }

}
