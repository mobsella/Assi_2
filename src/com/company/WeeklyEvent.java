package com.company;

import java.util.*;
import java.text.*;
import java.lang.String;

public class WeeklyEvent extends AbstractEvent {
    private Date limit;
    private int recurrences = 1;
    private int nos_calls = 0;

    public WeeklyEvent(String description, Date startTime, Date endTime, Date limit) {
        super(startTime, endTime, description);
        if (startTime.compareTo(limit) > 0) {
            throw new IllegalArgumentException("Limit date must appear after StartTime");
        } else {
            this.limit = limit;

            Date n = this.addDays(this.getStartTime(), 7);
            while (!n.after(limit)) {
                recurrences++;
                n = this.addDays(n, 7);
            }
        }
    }

    public Date getLimit() {
        return limit;
    }

    public int getRecurrences() {
        return recurrences;
    }


    public void setLimit(Date limit) {
        if (this.getStartTime().compareTo(limit) > 0)
            throw new IllegalArgumentException("Limit date should be after StartTime");
        else
            this.limit = limit;
    }

    public void setRecurrences(int recurrences) {
        this.recurrences = recurrences;
    }

    @Override
    public Date nextOccurrence() {
        nos_calls++;
        Date x;
        if (nos_calls <= recurrences) {
            x = this.addDays(this.getStartTime(), 7 * (nos_calls - 1));
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
            x = this.addDays(this.getStartTime(), 7 * (noss - 1));
        }
        return x;
    }

    public String toString() {
        return ("{Description: " + "'" + this.getDescription() + "'" + "," + " Start Time: " + "'" + this.getStartTime()
                + "'" + "," + " End Time: " + "'" + this.getEndTime() + "'" + "," + " numberOfOccurrences: " + "'" +
                this.recurrences + "'" + "," + " limit: " + "'" + this.limit + "'}");
    }

}