package com.company;


public class Notifications implements Observer {
    private static int observerIDTracker = 0;
    private int observerID;
    private Subject stockGrabber;


    public Notifications(Subject stockGrabber) {

        this.stockGrabber = stockGrabber;


        this.observerID = ++observerIDTracker;

        System.out.println("New Observer " + this.observerID);


        stockGrabber.register(this);

    }


    @Override
    public void update() {
        System.out.println("Planner Has Been Updated");
    }
}


