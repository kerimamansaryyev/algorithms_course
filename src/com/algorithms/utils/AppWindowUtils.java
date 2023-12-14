package com.algorithms.utils;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeriesCollection;

final public class AppWindowUtils {

    public static ChartPanel createChartPanel(XYSeriesCollection dataset){
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Performance Comparison of Algorithms",
                "Problem Size",
                "Execution Time (ns)",
                dataset
        );
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        return  chartPanel;
    }
}
