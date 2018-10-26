package container;

import example.LandContainer;

import java.util.ArrayList;
import java.util.List;

public class FlowLayout implements LayerLayout<Land> {
    private ArrayList<Land> areas;
    public static final int HORIZONTAL=0;
    public static final int VERTICAL=1;
    private int orientation;
    public FlowLayout(int orientation)
    {
        areas=new ArrayList<>();
        this.orientation=orientation;

    }
    @Override
    public List<Land> getallAreas()
    {
        return areas;
    }
    @Override
    public Land setArea(Land area,int location)
    {
        if(location==areas.size())
        {
            areas.add(area);
            return area;
        }
        else
        {
            return null;
        }

    }
    @Override
    public Land getArea(int location)
    {
        return areas.get(location);
    }
    public int getOrientation(){return orientation;}
    public void regulate(int length,int width)
    {
        List<Land> allareas = getallAreas();
        if (getOrientation() == FlowLayout.HORIZONTAL) {
            ArrayList<Land> matchparents = new ArrayList<>();
            int leaveLength=length;
            for (Land land : allareas) {
                if (land instanceof SpecificLand) {
                    if (land.getLength() == -1) {
                        matchparents.add(land);
                    }
                    else if (land.getLength() > length) {
                        land.setLength(length);
                        leaveLength=0;
                    }
                    else
                    {
                        leaveLength=leaveLength-land.getLength();
                    }
                    if (land.getWidth() == -1) {
                        land.setWidth(width);
                    }
                    else if (land.getWidth() > width) {
                        land.setWidth(width);
                    }

                }
                else if(land instanceof LandContainer)
                {
                    if (land.getLength() == -1) {
                        matchparents.add(land);
                    }
                    else if (land.getLength() > length) {
                        land.setLength(length);
                        leaveLength=0;
                    }
                    else
                    {
                        leaveLength=leaveLength-land.getLength();
                    }
                    if (land.getWidth() == -1) {
                        land.setWidth(width);
                    }
                    else if (land.getWidth() > width) {
                        land.setWidth(width);
                    }
                    ((LandContainer)land).regulate();
                }


            }
            int matches=matchparents.size();;
            for(Land match:matchparents)
            {
                match.setLength(leaveLength/matches);
            }
        }
        else if (getOrientation() == FlowLayout.VERTICAL) {
            ArrayList<Land> matchparents = new ArrayList<>();
            int leaveWidth=width;
            for (Land land : allareas) {
                if (land instanceof SpecificLand) {

                    if (land.getLength() == -1) {
                        land.setLength(length);
                    }
                    else if (land.getLength() > length) {
                        land.setLength(length);
                    }
                    if (land.getWidth() == -1) {
                        matchparents.add(land);
                    }
                    else if (land.getWidth() > width) {
                        land.setWidth(width);
                        leaveWidth=0;
                    }
                    else
                    {
                        leaveWidth=leaveWidth-land.getWidth();
                    }

                }
                else if(land instanceof LandContainer)
                {
                    if (land.getLength() == -1) {
                        land.setLength(length);
                    }
                    else if (land.getLength() > length) {
                        land.setLength(length);
                    }
                    if (land.getWidth() == -1) {
                        matchparents.add(land);
                    }
                    else if (land.getWidth() > width) {
                        land.setWidth(width);
                        leaveWidth=0;
                    }
                    else
                    {
                        leaveWidth=leaveWidth-land.getWidth();
                    }
                    ((LandContainer)land).regulate();
                }


            }
            int matches=matchparents.size();;
            for(Land match:matchparents)
            {
                match.setLength(leaveWidth/matches);
            }

        }
    }


}
