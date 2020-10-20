package com.company;

public class GameBoard {

    Animals[] animals;
    String[][] str = new String[10][10];

    public GameBoard(Animals[] animals) {
        this.animals = animals;
    }

    public void fill() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                str[i][j] = " ";
            }
        }


        for (Animals zebras : animals) {
            if (zebras instanceof Zebra) {
                Zebra zebra = (Zebra) zebras;
                if (zebra.getDead() == true) {
                    str[zebra.getX()][zebra.getY()] = " ";
                } else {
                    str[zebra.getX()][zebra.getY()] = "z";
                }
            }
        }


        for (Animals cheetahs : animals) {
            if (cheetahs instanceof Cheetah) {
                Cheetah cheetah = (Cheetah) cheetahs;
                str[cheetah.getX()][cheetah.getY()] = cheetah.getName();
            }

        }
    }


    public void print() {
        fill();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("[" + str[i][j] + "] ");
                if (j == 9) {
                    System.out.println();
                    /// System.out.println ("-----------------------------------------------");
                }


            }
        }

    }


}
