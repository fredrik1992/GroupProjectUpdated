package com.company;

public class Zebra extends Animals {
    private boolean dead;

    public Zebra() {
        steps = 1;
        dead = false;
        turnToSleepOn = 1;

    }


    public boolean getDead() {
        return dead;
    }

    public void setDead() {
        dead = true;
    }


}

