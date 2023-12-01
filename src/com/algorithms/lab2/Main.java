package com.algorithms.lab2;

import com.algorithms.utils.AppWindowUtils;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main extends JFrame {

    private Main(){
        getContentPane().add(AppWindowUtils.createChartPanel(createDataset()));
        pack();
        setVisible(true);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(Main::new);
    }

    private static XYSeriesCollection createDataset(){
        final Algorithm[] algorithms = new Algorithm[]{
                new Algorithm1(),
                new Algorithm2(),
        };
        final int[] problemSizes = {
                100,
                200,
                300,
                400,
                500,
                600,
                700,
                800,
                900,
                1000,
        };
        final Map<Integer, int[]> inputs = new HashMap<>();

        for(int pSize:problemSizes){
            inputs.put(pSize, generateRandomArray(pSize));
        }

        final var dataSet = new XYSeriesCollection();

        for(final Algorithm algorithm: algorithms){
            final XYSeries series = new XYSeries(algorithm.getName());
            for(final int problemSize: problemSizes){
                final var input = inputs.get(problemSize);
                long startTime = System.nanoTime();
                algorithm.findThirdLargest(input);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                series.add(problemSize, duration);
            }
            dataSet.addSeries(series);
        }

        return dataSet;
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000); // Adjust the bound as needed
        }
        return array;
    }

}
