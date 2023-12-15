package com.algorithms.lab7;

import java.util.Arrays;

public class DecisionTreeAlgorithmFourElements {


    public static void main(String[] args) {
        sortArray();
    }

    private static void sortArray(){
        final int[] arr = {4,3,2,1};
        // Round 1
        swap(arr, 0, 1);
        swap(arr, 2, 3);

        // Round 2
        swap(arr, 1, 3);

        // Round 3
        swap(arr, 0, 2);

        // Round 4
        swap(arr, 1, 2);

        // Round 5
        swap(arr, 1, 2);

        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j){
        if (arr[i] > arr[j]) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        else{
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }

}
