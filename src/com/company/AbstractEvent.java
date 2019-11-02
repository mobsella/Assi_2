package com.company;

import java.util.Calendar;
import java.util.Date;
import java.text.*;
import java.lang.String;

public abstract class AbstractEvent {
    private String description;
    private Date startTime;
    private Date endTime;

    public AbstractEvent(Date startTime, Date endTime, String description) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public abstract boolean hasMoreOccurrences();

    public abstract Date nextOccurrence();

    public abstract Date getLastRecurrence();

    public abstract void init();

    public Date addDays(Date date, int i) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        c1.add(Calendar.DATE, i);
        date = c1.getTime();
        return date;
    }


}




