package com.company;

import java.util.Comparator;
import java.util.Date;

public class LastOccComparator implements Comparator<AbstractEvent> {
    @Override
    public int compare(AbstractEvent o1, AbstractEvent o2) {
        int x;
        Date d1, d2;

        d1 = o1.getLastRecurrence();
        d2 = o2.getLastRecurrence();

        if (d1.before(d2))
            x = -1;
        else if (d1.after(d2))
            x = 1;
        else
            x = 0;
        return x;
    }


}
