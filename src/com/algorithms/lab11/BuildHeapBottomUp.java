package com.algorithms.lab11;

public class BuildHeapBottomUp {
    private static int comparisons = 0;

    public static int buildHeapBottomUp(int[] arr) {
        comparisons = 0;
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyBottomUp(arr, i, n);
        }

        return comparisons;
    }

    private static void heapifyBottomUp(int[] arr, int index, int heapSize) {
        int largest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < heapSize && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }
        comparisons++;

        if (rightChild < heapSize && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }
        comparisons++;

        if (largest != index) {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            heapifyBottomUp(arr, largest, heapSize);
        }
    }

    public static void main(String[] args) {
        int[] dataSet = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        int comparisonsQ2 = buildHeapBottomUp(dataSet);
        System.out.println("Question 2 Comparisons: " + comparisonsQ2);
    }
}

