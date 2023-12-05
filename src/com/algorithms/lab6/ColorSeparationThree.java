package com.algorithms.lab6;

public class ColorSeparationThree {

    public static void separateColors(String[] array) {
        int bluePointer = 0;
        int greenPointer = 0;
        int redPointer = array.length - 1;

        while (greenPointer <= redPointer) {
            if (array[greenPointer].equals("Blue")) {
                String temp = array[bluePointer];
                array[bluePointer] = array[greenPointer];
                array[greenPointer] = temp;
                bluePointer++;
                greenPointer++;
            } else if (array[greenPointer].equals("Red")) {
                String temp = array[greenPointer];
                array[greenPointer] = array[redPointer];
                array[redPointer] = temp;
                redPointer--;
            } else {
                greenPointer++;
            }
        }
    }

    public static void main(String[] args) {
        String[] toys = {"Blue", "Red", "Green", "Blue", "Green", "Red"};
        separateColors(toys);

        for (String toy : toys) {
            System.out.print(toy + " ");
        }
    }
}

