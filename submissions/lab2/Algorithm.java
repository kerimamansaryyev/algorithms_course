package com.algorithms.lab2;

public interface Algorithm {

    String getName();

    int findThirdLargest(int[] array);

    static  void main(String[] args){
        final var algorithms = new Algorithm[]{
                new Algorithm1(),
                new Algorithm2()
        };

        final int[] basicInput = new int[]{7, 20, 18, 4, 20, 19, 20, 3};

        for(final var algo: algorithms){
            System.out.println("Executing: " + algo.getName());
            System.out.println("Result: " + algo.findThirdLargest(basicInput));
        }
    }

}

class Algorithm2 implements  Algorithm {

    @Override
    public String getName() {
        return "Algorithm 2";
    }

    @Override
    public int findThirdLargest(int[] array) {
        if(array.length == 0){
            return  Integer.MIN_VALUE;
        }
        int max = Integer.MIN_VALUE, preMax = Integer.MIN_VALUE, prePreMax = Integer.MIN_VALUE;

        // n for number of comparisons under the enhanced loop
        // 2n for index traversing under the enhanced loop
        for (int i=0;i<array.length;i++) {
            // n times array[i] has been accessed
            int number = array[i];
            // n for comparison
            if (number > max) {
                // n for assignment
                max = number;
            }
            // (n-1) for comparisons
            else if (number > preMax) {
                // (n-1) for assignment
                preMax = number;

                // (n-2) for comparisons
            } else if (number > prePreMax) {
                // (n-2) for assignments
                prePreMax = number;
            }
        }

        return  prePreMax;
    }
}

class Algorithm1 implements  Algorithm {
    @Override
    public String getName() {
        return "Algorithm 1";
    }

    @Override
    public int findThirdLargest(int[] array) {
        if(array.length == 0){
            return  -1;
        }

        int maxIndex = -1, secondMaxIndex = -1;

        int max = Integer.MIN_VALUE;

        // i=0 is 1
        // i<array.length is n
        // i++ is 2n
        for(int i=0;i<array.length;i++){
            // array[i] is n
            // array[i] > max is n
            if(array[i] > max){
                // assignment + index = 2n
                max = array[i];
                // assignment is n
                maxIndex = i;
            }
        }
        // Total: 8n for this loop

        max = Integer.MIN_VALUE;


        for(int i=0;i<array.length;i++){
           if(i != maxIndex && array[i] > max){
                max = array[i];
                secondMaxIndex = i;
           }
        }

        max = Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            if(i != maxIndex && i != secondMaxIndex && array[i] > max){
                max = array[i];
            }
        }

        return max;
    }
}
