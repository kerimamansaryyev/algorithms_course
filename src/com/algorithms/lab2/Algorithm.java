package com.algorithms.lab2;

public interface Algorithm {

    String getName();

    int findThirdLargest(int[] array);

    static  void main(String[] args){
        final var algorithms = new Algorithm[]{
                new Algorithm1(),
                new Algorithm2()
        };

        final int[] basicInput = new int[]{6,10,1,2};

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


        for (int i=0;i<array.length;i++) {
            int number = array[i];

            if (number > max) {
                prePreMax = preMax;
                preMax = max;
                max = number;
            }
            else if(number > preMax){
                prePreMax = preMax;
                preMax = number;
            }
            else if(number > prePreMax){
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


        for(int i=0;i<array.length;i++){
            if(array[i] > max){

                max = array[i];

                maxIndex = i;
            }
        }


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
