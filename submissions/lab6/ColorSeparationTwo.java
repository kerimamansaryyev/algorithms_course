package com.algorithms.lab6;

public class ColorSeparationTwo {

    public static void separateColors(String[] array) {
        int bluePointer = 0;
        int redPointer = array.length - 1;

        while (bluePointer < redPointer) {
            if (array[bluePointer].equals("Blue")) {
                bluePointer++;
            } else {
                String temp = array[bluePointer];
                array[bluePointer] = array[redPointer];
                array[redPointer] = temp;
                redPointer--;
            }
        }
    }

    public static void main(String[] args) {
        String[] toys = {"Blue", "Red", "Blue", "Red", "Blue"};
        separateColors(toys);

        for (String toy : toys) {
            System.out.print(toy + " ");
        }
    }
}

