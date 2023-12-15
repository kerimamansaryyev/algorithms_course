package com.algorithms.lab11;

public class BuildHeapTopDown {
    private static int comparisons = 0;

    public static int buildHeapTopDown(int[] arr) {
        comparisons = 0;
        for (int i = 1; i < arr.length; i++) {
            heapifyTopDown(arr, i);
        }
        return comparisons;
    }

    private static void heapifyTopDown(int[] arr, int index) {
        int parent = (index - 1) / 2;

        while (index > 0 && arr[index] > arr[parent]) {
            int temp = arr[index];
            arr[index] = arr[parent];
            arr[parent] = temp;
            comparisons++;
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    public static void main(String[] args) {
        int[] dataSet = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int comparisonsQ1 = buildHeapTopDown(dataSet);
        System.out.println("Question 1 Comparisons: " + comparisonsQ1);
    }
}

