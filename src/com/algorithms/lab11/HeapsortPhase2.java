package com.algorithms.lab11;

import java.util.Arrays;

public class HeapsortPhase2 {
    private static int comparisons = 0;

    public static int heapsortPhase2(int[] arr) {
        comparisons = buildHeapBottomUp(arr);

        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            comparisons += buildHeapBottomUp(Arrays.copyOfRange(arr, 0, i));
        }

        return comparisons;
    }

    private static int buildHeapBottomUp(int[] arr) {
        // Implement the BuildHeap Bottom-Up logic from Question 2
        // ...

        return comparisons;
    }

    public static void main(String[] args) {
        int[] dataSet = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int comparisonsQ3 = heapsortPhase2(dataSet);
        System.out.println("Question 3 Comparisons: " + comparisonsQ3);
    }
}

