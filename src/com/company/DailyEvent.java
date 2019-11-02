package com.company;

import java.util.Date;
import java.util.*;
import java.text.*;
import java.lang.String;


public class DailyEvent extends AbstractEvent {

    private int recurrences = 1;
    private int nos_calls = 0;

    public DailyEvent(String description, Date startTime, Date endTime, int recurrences) {
        super(startTime, endTime, description);
        if (recurrences > 0)
            this.recurrences = recurrences;
        else throw new IllegalArgumentException("Recurrences must be greater than zero (at least 1 (StartTime))");

    }

    public int getRecurrences() {

        return recurrences;
    }

    public void setRecurrences(int recurrences) {
        if (recurrences > 0)
            this.recurrences = recurrences;
        else throw new IllegalArgumentException("Recurrences must be greater than zero");
    }

    @Override
    public Date nextOccurrence() {
        nos_calls++;
        Date x;
        if (nos_calls <= recurrences) {
            x = this.addDays(this.getStartTime(), nos_calls - 1);
        } else {
            x = this.getStartTime();
        }
        return x;
    }

    public boolean hasMoreOccurrences() {
        return nos_calls < recurrences;
    }

    @Override
    public void init() {
        nos_calls = 0;
    }

    @Override
    public Date getLastRecurrence() {
        Date x = this.getStartTime();
        for (int noss = 1; noss <= recurrences; noss++) {
            x = this.addDays(this.getStartTime(), noss - 1);
        }
        return x;
    }

    public String toString() {
        return ("{Description: " + "'" + this.getDescription() + "'" + "," + " Start Time: " + "'" + this.getStartTime()
                + "'" + "," + " End Time: " + "'" + this.getEndTime() + "'" + "," + " numberOfOccurrences: " + "'" +
                this.recurrences + "'}");
    }


}
