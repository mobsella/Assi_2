package com.company;

import java.util.Comparator;

public class DescriptionComparator implements Comparator<AbstractEvent> {
    @Override
    public int compare(AbstractEvent o1, AbstractEvent o2) {
        return o1.getDescription().compareTo(o2.getDescription());
    }


}
