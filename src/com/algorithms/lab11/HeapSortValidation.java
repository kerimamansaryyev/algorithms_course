package com.algorithms.lab11;

import java.util.Arrays;

public class HeapSortValidation {
    public static void main(String[] args) {
        int[][] dataSets = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16},
                {2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15},
                {4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13, 14, 16, 15},
                {5, 6, 7, 4, 2, 3, 1, 8, 11, 13, 14, 16, 10, 12, 11, 9}
        };

        for (int i = 0; i < dataSets.length; i++) {
            int[] dataSet = Arrays.copyOf(dataSets[i], dataSets[i].length);
            int comparisonsQ4 = HeapsortPhase2.heapsortPhase2(dataSet);
            System.out.println("Data Set " + (i + 1) + " Comparisons: " + comparisonsQ4);
            System.out.println("Sorted Result: " + Arrays.toString(dataSet));
            System.out.println();
        }
    }
}

