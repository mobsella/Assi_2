package com.company;

import java.util.*;

public class Planner implements Subject {
    private int size = 0;
    private int index = 0;
    private ArrayList<AbstractEvent> Plans = new ArrayList<AbstractEvent>();
    private ArrayList<Observer> observers;

    public Planner(int size) {
        if (size > 0) {
            this.size = size;
            observers = new ArrayList<Observer>();
        } else throw new IllegalArgumentException("Size should be greater than 0");
    }

    public int getSize() {
        return size;
    }

    public int getIndex() {
        return index;
    }

    public boolean addEvent(AbstractEvent event) {
        if (index < size) {
            Plans.add(event);
            index++;
            notifyObserver();
            return true;
        } else {
            return false;
        }
    }


    public AbstractEvent eventAt(int pos) {
        if (pos < index && pos >= 0) {
            return Plans.get(pos);
        } else {
            throw new IllegalArgumentException("index out of range");
        }
    }


    public AbstractEvent remove(int pos) {
        if (pos < index && pos >= 0) {
            index--;
            return Plans.remove(pos);
        } else {
            throw new IllegalArgumentException("index out of range");
        }

    }


    public void display(Date date) {
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(date);
        for (int i = 0; i < index; i++) {
            if (Plans.get(i) instanceof DailyEvent) {
                DailyEvent daily = (DailyEvent) Plans.get(i);
                for (int j = 0; j < daily.getRecurrences(); j++) {
                    Date d = daily.nextOccurrence();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(d);
                    if (calendar.get(Calendar.DAY_OF_YEAR) == calendarDate.get(Calendar.DAY_OF_YEAR)) {
                        System.out.println(daily);
                    }
                }
            } else if (Plans.get(i) instanceof WeeklyEvent) {
                WeeklyEvent weekly = (WeeklyEvent) Plans.get(i);
                int j = 0;
                while (j < weekly.getRecurrences()) {
                    Date d = weekly.nextOccurrence();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(d);
                    if (calendar.get(Calendar.DAY_OF_YEAR) == calendarDate.get(Calendar.DAY_OF_YEAR)) {
                        System.out.println(weekly);
                    }
                    j++;
                }
            } else {
                System.out.println("ERROR!! not instance of daily or weekly event");
            }
        }
    }


    public void sort(Comparator<AbstractEvent> c) {
        Collections.sort(Plans, c);
    }


    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < index; i++) {
            str.append("Event number:").append(i).append("\n");
            if (Plans.get(i) instanceof DailyEvent) {
                DailyEvent daily = (DailyEvent) Plans.get(i);
                str.append(daily.toString());

            } else if (Plans.get(i) instanceof WeeklyEvent) {
                WeeklyEvent weekly = (WeeklyEvent) Plans.get(i);
                str.append(weekly.toString());

            } else {
                System.out.println("ERROR!! not instance of daily or weekly event");
            }
            str.append("\n");
        }

        return str.toString();
    }

    @Override
    public void register(Observer o) {
        observers.add(o);

    }

    @Override
    public void unregister(Observer o) {
        // Get the index of the observer to delete

        int observerIndex = observers.indexOf(o);

        // Print out message (Have to increment index to match)

        System.out.println("Observer " + (observerIndex + 1) + " deleted");

        // Removes observer from the ArrayList

        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {

        for (Observer observer : observers) {

            observer.update();

        }
    }


}



