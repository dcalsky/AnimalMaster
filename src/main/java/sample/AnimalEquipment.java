package sample;

import sample.Animal;
import node.Node;

//继承自node类的自定义装备类
public class AnimalEquipment extends Node {
    private String equipType;

    private Animal dresser;

    public void setEquipType(String equipType) {
        this.equipType = equipType;
    }

    public String getEquipType() {
        return equipType;
    }

    AnimalEquipment(String type) {
        equipType = type;
    }

    public void setDresser(Animal dresser) {
        this.dresser = dresser;
    }

    public void printStatus() {
        System.out.println(equipType + "(ID:" + this.getID() + ")" + "is dressed by " + dresser.nickname + "(ID:" + dresser.getID() + ")");
    }
}
