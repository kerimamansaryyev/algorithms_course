package com.algorithms.w3_2.kerim;

import java.util.Arrays;

public class Main {

    private static int getMaxChildIndex(int parentIndex, int[] arr, int lastIndex){
        if(parentIndex > lastIndex/2){
            return 0;
        }

        int max;
        final int leftIndex = parentIndex*2;
        final int rightIndex = (parentIndex*2)+1;

        if(rightIndex > lastIndex){
            max = Math.max(arr[parentIndex], arr[leftIndex]);
        }
        else {
            max = Math.max(arr[parentIndex], Math.max(arr[leftIndex], arr[rightIndex]));
        }

        if(max == arr[parentIndex]){
            return 0;
        }
        else if(max == arr[leftIndex]){
            return leftIndex;
        }
        else {
            return  rightIndex;
        }
    }
    private static void swap(int i, int j, int[] arr){
        final int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Going from [index] up to parent
    private static int upHeap(int index, int[] arr){
        int currentIndex = index;
        int numComparisons = 1;

        // currentIndex/2 is a parent index
        while (currentIndex > 1 && arr[currentIndex] > arr[currentIndex/2]){
            swap(currentIndex, currentIndex/2, arr);
            currentIndex = currentIndex/2;
            numComparisons++;
        }
        return  numComparisons;
    }

    private static int downHeap(int index, int[] arr, int lastIndex){
        int maxChildIndex = getMaxChildIndex(index, arr, lastIndex);
        int numOfComparisons = 1;
        int selfIndex = index;

        while(maxChildIndex != 0){
            swap(selfIndex, maxChildIndex, arr);
            selfIndex = maxChildIndex;
            maxChildIndex = getMaxChildIndex(maxChildIndex, arr, lastIndex);
            numOfComparisons++;
        }

        return  numOfComparisons;
    }
    private static int[] getCompleteBTree(int[] arr){
        final int[] newArr = new int[arr.length+1];
        newArr[0] = 0;
        for(int i=1, j=0;j<arr.length;i++,j++){
            newArr[i] = arr[j];
        }
        return  newArr;
    }

    private static int buildHeapTopDown(int[] arr){
        if(arr.length == 0){
            return 0;
        }

        int comparisons = 0;

        for(int i=1;i<=arr.length-1;i++){
            comparisons += upHeap(i, arr);
        }

        System.out.println("After the Top-Down: " + Arrays.toString(arr));

        return  comparisons;
    }

    private static int buildHeapBottomUp(int[] arr){
        if(arr.length == 0){
            return 0;
        }

        int comparisons = 0;

        for(int i=(arr.length-1)/2; i>0;i--){
            comparisons += downHeap(i, arr, arr.length-1);
        }

        System.out.println("After the Bottom-Up: " + Arrays.toString(arr));

        return  comparisons;
    }


    private static void heapSort(int[] arr){
        if(arr.length <= 2){
            return;
        }

        buildHeapBottomUp(arr);

        int lastIndex = arr.length-1;

        while(lastIndex > 1){
            final int temp = arr[1];
            arr[1] = arr[lastIndex];
            arr[lastIndex] =temp;
            downHeap(1, arr, --lastIndex);
        }
    }
    public static void main(String[] args) {

        final int[][] dataSets = {
                {80, 17, 28, 35, 49, 2, 15, 65, 36, 25},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16},
                {2, 1, 4, 3, 6, 5, 8, 7, 10, 9, 12, 11, 14, 13, 16, 15},
                {4, 2, 3, 1, 5, 8, 7, 6, 11, 10, 12, 9, 13, 14, 16, 15},
                {5, 6, 7, 4, 2, 3, 1, 8, 11, 13, 14, 16, 10, 12, 11, 9}
        };


        for(final int[] dataSet: dataSets){

            final int[] originalSample = getCompleteBTree(dataSet);

            System.out.println("Sample: " + Arrays.toString(originalSample));

            final int[] forTopDown = Arrays.copyOf(originalSample, originalSample.length);
            System.out.println("Top-down comparisons number: " + buildHeapTopDown(forTopDown));

            final int[] forBottomUp = Arrays.copyOf(originalSample, originalSample.length);
            System.out.println("Bottom-Up comparisons number: " + buildHeapBottomUp(forBottomUp));

            final int[] forHeapSort = Arrays.copyOf(originalSample, originalSample.length);
            heapSort(forHeapSort);
            System.out.println("Heap-sorted: " + Arrays.toString(forHeapSort));
            System.out.println();
        }
    }



}
