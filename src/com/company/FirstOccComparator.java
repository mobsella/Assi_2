package com.company;

import java.util.Comparator;

public class FirstOccComparator implements Comparator<AbstractEvent> {
    @Override
    public int compare(AbstractEvent o1, AbstractEvent o2) {
        int x;
        if(o1.getStartTime().before(o2.getStartTime()))
            x=-1;
        else if(o1.getStartTime().after(o2.getStartTime()))
            x=1;
        else
            x=0;
        return x;
    }


}



