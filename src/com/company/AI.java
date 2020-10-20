package com.company;


public class AI {

    int numberOfZebrasLeft;
    int round;

    Animals[] animals;
    AnimalList list;
    GameBoard plan;
    Message deathMessage;

    public AI() {
        list = new AnimalList();
        numberOfZebrasLeft = 0;
    }

    public void createArrays() {//this whole method is used to give our vectors a size and give them objects
        list.setAnimalQuantity();//using the list object we call on the method getQuantity and sets values for zebras and cheetas
        numberOfZebrasLeft = list.getQuantityZebras();//assigns the total number of zebras  alive at the start of the game
        animals = new Animals[list.getTotalAnimals()];
        list.setArrays(animals);// using our list object we send our vectors into it's set vector method that
        plan = new GameBoard(animals);
    }
    //assigns objects to them


    public void runGame() {//this lope runs the entire game using values from the animal vectors
        while (numberOfZebrasLeft > 0) {//checks if we reached the end of game''all zebras are dead''
            //if (numberOfZebrasLeft <= 2) {//slows the program down when 2 zebras are left in the game
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }


            round++;//adds to round to remember what round we are in
            System.out.println("\nRound: " + round);//prints the current round
            plan.print();

            for (Animals animal : animals) { //resets cheetas to c
                if (animal instanceof Cheetah) {
                    Cheetah cheetah = (Cheetah) animal;
                    cheetah.setName("c");
                }
            }

            checkAnimals();
            checkKilling();
        }
    }

    public void checkAnimals() {
        for (Animals animal : animals) {


            if (animal instanceof Cheetah) {

                hunt(animal);


            } else {

                moveAnimals(animal);
            }
        }


    }


    // This loop moves all the cheetahs
    public void moveAnimals(Animals animal) {



            switch (animal.getDirection()) {//otherwise it just moves it
                case "up":// checks if the value up is in the current cheetah
                    if (animal.getY() == 9) {//checks if they have reached the edge
                        while (animal.getDirection().equals("up"))//changes the value to a random direction that
                            animal.direction();                   //is not the current one
                    } else {// if they are not at the edge the cheetah is moved
                        animal.setY(animal.getSteps(), true);
                    }

                    break;
                case "down":
                    if (animal.getY() == 0) {
                        while (animal.getDirection().equals("down"))
                            animal.direction();
                    } else {
                        animal.setY(animal.getSteps(), false);
                    }

                    break;
                case "left":
                    if (animal.getX() == 0) {
                        while (animal.getDirection().equals("left"))
                            animal.direction();
                    } else {
                        animal.setX(animal.getSteps(), false);
                    }

                    break;
                case "right":
                    if (animal.getX() == 9) {
                        while (animal.getDirection().equals("right"))
                            animal.direction();
                    } else {
                        animal.setX(animal.getSteps(), true);
                    }
                    break;
            }
        }


    public void hunt(Animals cheetah) {

        int currentIndexCount = 0;
        int indexOfClosest = 0;
        int lastCheckedzebraX;
        int lastCheckedzebraY;
        int pytogara = 100;

        for (Animals zebras : animals) {

            if (zebras instanceof Zebra) {
                Zebra zebra = (Zebra) zebras;
                if(zebra.getDead()==false) {
                    lastCheckedzebraX = (cheetah.x + zebra.x) * 2;
                    lastCheckedzebraY = (cheetah.y + zebra.y) * 2;
                    if (lastCheckedzebraX + lastCheckedzebraY < pytogara) {
                        pytogara = lastCheckedzebraX + lastCheckedzebraY;
                        indexOfClosest = currentIndexCount;

                    }
                }
            }
            currentIndexCount++;
        }
        int count = 0;
        while (cheetah.getSteps() > count) {
            if (cheetah.getY() < animals[indexOfClosest].getY()) {
                cheetah.setY(1, true);
                checkKilling();


            } else if (cheetah.getY() > animals[indexOfClosest].getY()) {
                cheetah.setY(1, false);
                checkKilling();

            } else if (cheetah.getX() < animals[indexOfClosest].getX()) {
                cheetah.setX(1, true);
                checkKilling();
            } else if (cheetah.getX()> animals[indexOfClosest].getX()) {
                cheetah.setX(1, false);
                checkKilling();
            }
            count++;


        }
    }




        public void checkKilling () {

            for (Animals animal : animals) {// cheecks every cheetah against each zebra to see if they have the same
                int zebrasToPrint = 0;

                if (animal instanceof Cheetah) {
                    Cheetah cheetah = (Cheetah) animal;
                    for (Animals zebras : animals) {
                        if (zebras instanceof Zebra) {
                            Zebra zebra = (Zebra) zebras;
                            if (cheetah.getX() == zebra.getX() && cheetah.getY() == zebra.getY()) {
                                if (!cheetah.isResting() && !zebra.getDead()) {
                                    ((Zebra) zebras).setDead();
                                    cheetah.turnCounter = 3;
                                    cheetah.setName("C");
                                    numberOfZebrasLeft--;//this will eventually end the game
                                    zebrasToPrint++;


                                }
                            }
                        }
                    }
                }
                if (zebrasToPrint > 0) {//checks if we need to print enything this round
                    printDeadZebras();
                }
            }

        }





                public void printDeadZebras () {
                    deathMessage = new Message();
                    String zebraWaysToDiePrint = deathMessage.Choice();

                    System.out.print("\n" +
                            "\n" +
                            "\n" +
                            "\n" +
                            "                                                                                                                                        _____\n" +
                            "                                                                                                                                      _/ _ _ \\\n" +
                            "                                                                                                                                     /    \\ \\_\\__\n" +
                            "                                                                                                                               _____/    /(      \\\n" +
                            "                                                                                                                              |  _______/         \\\n" +
                            "                                                                                                                             _| /                  \\     \n" +
                            "                                                                                                                ____________|__/                    \\\n" +
                            "                                                                                                               /                            __       \\   \n" +
                            "                                                         _____________/\\____                                __/                            /   \\      | \n" +
                            "  ---                        __________                 /             \\/    \\___                           /                              |     \\____/ \n" +
                            "  | |                       |          \\_______________/                        )                         /                               |          \n" +
                            "  | |          -------------                                            \\______/                   ______/                      /         /\n" +
                            "  \\ \\         / -----------                                             /                         / _____                      /         /\n" +
                            "   \\ \\-------/ /          /                                            /              -- ________/ /   /                       |        /______\n" +
                            "    ----------/          /                                            |               \\___________/    |       _____            \\      _____   \\   \n" +
                            "                  ______/        ____                                \\|                                |      /    \\_____________\\          \\   \\\n" +
                            "                 /              /    \\___                             \\                                |     /     /              \\________  |   \\\n" +
                            "                /              /         \\_______________________|     \\                              /     /     /                        | |\\  |\n" +
                            "               /  ____________/                                  |      \\_________                   /   __/  ___|                         | | \\ |\n" +
                            "              (  /                                                \\_____________  \\                 /   /    /                             | | / /\n" +
                            "           ___| /                                                  \\    \\       |  \\             __/  _//___/                              / /  /\n" +
                            "          |   _/                                                    \\__  \\      |   |           /    /                                   |  /\\__|\n" +
                            "          \\/_/                                                         \\  \\      \\ /           /____/                                    \\__|\n" +
                            "                                                                        \\  \\__\n" +
                            "                                                                         \\ ____\\                                                                        \n" +
                            "                                                                             ");
                    System.out.printf("%s", zebraWaysToDiePrint);
                }
            }

