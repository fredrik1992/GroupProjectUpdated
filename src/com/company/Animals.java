package com.company;


import java.util.Random;

public abstract class Animals {
    Random random = new Random();
    String dir;
    int x;
    int y;
    int direction;
    int turnCounter;
    int id;
    protected int turnToSleepOn;
    protected int steps;
    boolean resting;


    public Animals() {
        x = random.nextInt(10);//gives random x and y values to all animals
        y = random.nextInt(10);
        direction = random.nextInt(4);
        resting = false;
        turnCounter = 0;
        direction();

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setRest() {//used to check if the cheetah has moved more then 3 turns then it have to rest
        if (turnCounter == turnToSleepOn) {
            resting = true;
            turnCounter = 0;
        } else {
            resting = false;
        }
    }

    public int getSteps() {// called when moving an animal to keep track on its turn and if it has to rest and getting how many steps to take
        turnCounter++;//adds to turncounter
        setRest();// checks if cheetah has to rest or not
        direction();// gives a random direction
        return steps;// return how many steps to move 2 or 1
    }


    public void setX(int x, boolean xCheck) {//used when moving animal to check if x is moving left or right
        if (xCheck == true) {
            this.x += x;

        } else if (xCheck == false) {
            this.x -= x;
        }

    }

    public void setY(int y, boolean yCheck) {//used when moving animal to check if y is moving up or down.

        if (yCheck == true) {
            this.y += y;

        } else if (yCheck == false) {
            this.y -= y;
        }
    }


    public void direction() {//called to change direction to a random way to the value dir
        direction = random.nextInt(4);
        switch (direction) {
            case 0: // up
                dir = "up";
                break;
            case 1: // down
                dir = "down";
                break;
            case 2: // left
                dir = "left";
                break;
            case 3: // right
                dir = "right";
                break;
        }
    }






    public String getDirection() {
        return this.dir;
    }
    public boolean isResting() {
        return resting;
    }
}