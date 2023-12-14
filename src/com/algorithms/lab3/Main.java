package com.algorithms.lab3;


public class Main {
    public static int beautiful(int[] A, int n){
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum+=A[i];
        }
        return sum;
    }

    // Algorithm analysis:
    // Here, as we loop through all the elements in an array the worst case is n,
    // and the best case is also n as we will loop through all items



}
