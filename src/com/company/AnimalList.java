package com.company;

import java.util.Scanner;

public class AnimalList {

    private int quantityCheetahs;
    private int quantityZebras;
    private int totalAnimals;


    public AnimalList() {
        this.quantityCheetahs = 0;
        this.quantityZebras = 0;


    }

    public void setQuantityCheetahs(int quantityCheetahs) {
        this.quantityCheetahs = quantityCheetahs;
    }
    public void setQuantityZebras(int quantityZebras) {
        this.quantityZebras = quantityZebras;
    }

    public int getQuantityZebras() {
        return quantityZebras;
    }

    public int getTotalAnimals() {
        return totalAnimals;
    }


    public void setAnimalQuantity() {// takes two inputs and gives them to quantity of zebras and cheetahs
        Scanner scan = new Scanner(System.in);
        boolean loop = true;

        while (loop  == true) {
            System.out.println("please provide the quantity of Zeebras in the game and zebras");
            setQuantityZebras(scan.nextInt());
            setQuantityCheetahs(scan.nextInt());
            if (quantityZebras >= quantityCheetahs && quantityCheetahs > 0) {//checks that zebras are never less then cheetahs
                System.out.println("the games is set time to play!");
                totalAnimals = quantityCheetahs + quantityZebras;
                loop = false;

            } else {
                System.out.printf("you have entered the wrong number of cheetahs give a number that is not 0" +
                        "and is less or equal to the number of zebras %n");
            }
        }

    }

    public void setArrays(Animals[] animals) {

        for (int i = 0; i < totalAnimals; i++) {
            if (i < quantityZebras) {
                animals[i] = new Zebra();
            } else {
                animals[i] = new Cheetah();
            }


        }


    }
}
