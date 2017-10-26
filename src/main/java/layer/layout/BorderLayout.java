package layer.layout;

import land.Land;
import land.LandContainer;
import layer.LayerLayout;

import java.util.ArrayList;
import java.util.List;

public class BorderLayout implements LayerLayout<Land> {
    private ArrayList<Land> areas;
    public static final int Center=0;
    public static final int South=1;
    public static final int North=2;
    public static final int East=3;
    public static final int West=4;
    public BorderLayout()
    {
        areas=new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            areas.add(null);
        }


    }
    @Override
    public List<Land> getallAreas()
    {
        return areas;
    }
    @Override
    public Land setArea(Land area,int location)
    {
        return areas.set(location,area);
    }
    @Override
    public Land getArea(int location)
    {
        return areas.get(location);
    }
    public void regulate(int length,int width)
    {
        List<Land> allareas=getallAreas();
        int leavelength=length;
        int leavewidth=width;
        if(allareas.get(BorderLayout.North)!=null)
        {
            allareas.get(BorderLayout.North).setLength(length);
            allareas.get(BorderLayout.North).setWidth(width/5);
            leavewidth=leavelength-leavelength/5;
            if(allareas.get(BorderLayout.North) instanceof LandContainer)
            {
                ((LandContainer) allareas.get(BorderLayout.North)).regulate();
            }
        }
        if(allareas.get(BorderLayout.South)!=null)
        {
            allareas.get(BorderLayout.South).setLength(length);
            allareas.get(BorderLayout.South).setWidth(width/5);
            leavewidth=leavewidth-leavewidth/5;
            if(allareas.get(BorderLayout.South) instanceof LandContainer)
            {
                ((LandContainer) allareas.get(BorderLayout.South)).regulate();
            }
        }
        if(allareas.get(BorderLayout.East)!=null)
        {
            allareas.get(BorderLayout.East).setLength(length/8);
            allareas.get(BorderLayout.East).setWidth(leavewidth);
            leavelength=leavelength-leavelength/8;
            if(allareas.get(BorderLayout.East) instanceof LandContainer)
            {
                ((LandContainer) allareas.get(BorderLayout.East)).regulate();
            }
        }
        if(allareas.get(BorderLayout.West)!=null)
        {
            allareas.get(BorderLayout.West).setLength(length/8);
            allareas.get(BorderLayout.West).setWidth(leavewidth);
            leavelength=leavelength-leavelength/8;
            if(allareas.get(BorderLayout.West) instanceof LandContainer)
            {
                ((LandContainer) allareas.get(BorderLayout.West)).regulate();
            }
        }
        if(allareas.get(BorderLayout.Center)!=null)
        {
            allareas.get(BorderLayout.Center).setLength(leavelength);
            allareas.get(BorderLayout.Center).setWidth(leavewidth);
            if(allareas.get(BorderLayout.Center)!=null &&allareas.get(BorderLayout.Center) instanceof LandContainer)
            {
                ((LandContainer) allareas.get(BorderLayout.Center)).regulate();
            }
        }
    }

}
