package com.algorithms.lab1;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.util.*;

public class Main extends JFrame {


    private interface Algorithm {
        String getName();
        int run(int[] input);



        Algorithm[] availableAlgorithms = new Algorithm[]{
                creatExtraArrayWithNestedLoopAlgo(),
                createNestedLoopWithoutExtraArray(),
                createFindAmongMaxAndMinEvensAlgo(),
        };

        static Algorithm creatExtraArrayWithNestedLoopAlgo() {
            return  new Algorithm() {
                @Override
                public String getName() {
                    return "Algorithm 1";
                }

                @Override
                public int run(int[] input) {
                    return  extraArrayWithNestedLoopAlgo(
                            input
                    );
                }
            };
        }

        static Algorithm createNestedLoopWithoutExtraArray() {
            return  new Algorithm() {
                @Override
                public String getName() {
                    return "Algorithm 2";
                }

                @Override
                public int run(int[] input) {
                    return  nestedLoopWithoutExtraArray(
                            input
                    );
                }
            };
        }

        static Algorithm createFindAmongMaxAndMinEvensAlgo(){
            return  new Algorithm() {
                @Override
                public String getName() {
                    return "Algorithm 3";
                }

                @Override
                public int run(int[] input) {
                    return findAmongMaxAndMinEvensAlgo(input);
                }
            };
        }
    }

    public Main(String title) {
        super(title);
        // Just to see if result is correct
        for(final var algo: Algorithm.availableAlgorithms){
            execAlgoTest(algo, generateRandomArray(8));
        }

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Performance Comparison of Algorithms",
                "Problem Size",
                "Execution Time (ns)",
                createDataSet()
        );
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
        setVisible(true);
        pack();
    }



    private static int extraArrayWithNestedLoopAlgo(int[] integers){
        final ArrayList<Integer> evens = new ArrayList<>();

        for(int integer: integers){
            if(integer%2 == 0){
                evens.add(integer);
            }
        }

        // in case if even integers do no not exist
        int distance = -1;

        for(int i=0;i<evens.size();i++){
            for(int j=i+1;j<evens.size();j++){
                int temp = evens.get(i) - evens.get(j);
                temp = temp >= 0? temp: -temp;
                if(temp>=distance){
                    distance = temp;
                }
            }
        }

        return distance;
    }

    private static int nestedLoopWithoutExtraArray(int[] integers){
        int maxDistance = -1;

        for (int i = 0; i < integers.length; i++) {

            if (integers[i] % 2 != 0) {
                continue;
            }

            for (int j = i + 1; j < integers.length; j++) {
                    if (integers[i] % 2 != 0) {
                        continue;
                    }

                    int distance = integers[i] - integers[j];

                    distance = distance >= 0? distance: -distance;

                    if (distance > maxDistance) {
                            maxDistance = distance;
                    }
            }

        }

        return maxDistance;
    }

    private static int findAmongMaxAndMinEvensAlgo(int[] integers){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        boolean foundAny = false;

        for (int num : integers) {
            if (num % 2 != 0){
                continue;
            }

            foundAny = true;
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }

        }

        if(!foundAny){
            return  -1;
        }

        return max - min;

    }

    private XYSeriesCollection createDataSet(){
        final int[] problemSizes = {
                1000,
                2000,
                3000,
                4000,
                5000,
                6000,
                7000,
                8000,
                9000,
                10000
        };
        final Algorithm[] algorithms = Algorithm.availableAlgorithms;
        final XYSeriesCollection dataset = new XYSeriesCollection();

        final Map<Integer, int[]> inputsPerProblemSize = new HashMap<>();

        for(final int problemSize: problemSizes){
            inputsPerProblemSize.put(problemSize, generateRandomArray(problemSize));
        }

        for(final Algorithm algorithm: algorithms){
            final XYSeries series = new XYSeries(algorithm.getName());
            for(final int problemSize: problemSizes){
                final var input = inputsPerProblemSize.get(problemSize);
                long startTime = System.nanoTime();
                algorithm.run(input);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                series.add(problemSize, duration);
            }
            dataset.addSeries(series);
        }

        return  dataset;
    }

    private void execAlgoTest(Algorithm algorithm, int[] input){
        System.out.println("Executing: " + algorithm.getName());
        System.out.println("Input: " + Arrays.toString(input));
        final int result = algorithm.run(input);
        System.out.println("Result: " + result);
    }

    private int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000); // Adjust the bound as needed
        }
        return array;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new Main("Algorithm Performance"));
    }
}