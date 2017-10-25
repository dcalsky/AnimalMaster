/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FarmManager;

import farmobjects.LivingObjects;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author 18359
 */
public abstract class FarmManager extends LivingObjects{
    
    private static List<FarmManager> objs = new ArrayList<>();
    
    protected FarmManager(){}
    
    protected void destroy(FarmManager FarmManager){
	super.destroy(FarmManager);
	objs.remove(FarmManager);
    }
    //所有继承类需要重载destroy
    public static int getNumber()
    {
	Set<String> set = new HashSet<>();
	for(FarmManager go : objs)
	{
	    set.add(go.getClass().getName());
	}
	System.out.println("objs: " +objs.size());
	System.out.println("set: " + set.size());
	return objs.size() - set.size();
    }
    
    protected void addPrototype (FarmManager FarmManager) {
	super.addPrototype(FarmManager);
	objs.add(FarmManager);
    }
    
    public void showContent(){
        for(FarmManager action: objs){
            System.out.println(action.getClass().getName());
        }
    }
}
