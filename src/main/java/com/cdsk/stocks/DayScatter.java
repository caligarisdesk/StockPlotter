package com.cdsk.stocks;


import javax.imageio.ImageIO;
import javax.swing.*;

import javafx.scene.chart.Chart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.Range;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.util.Rotation;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class DayScatter {

    private static final long serialVersionUID = 1L;
    JFreeChart chart;
    Random r;
    public DayScatter(String chartTitle) {
        // This will create the dataset
        // based on the dataset we create the chart
        r=new Random();

        this.chart = createChart(createDataset(), chartTitle);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.getDomainAxis().setRange(0,30);
        plot.getRangeAxis().setRange(0,30);

    }

    /**
     * Creates a sample dataset
     */
    private XYDataset createDataset() {
        final XYSeries firefox = new XYSeries( "Firefox" );
        firefox.add( 1.0 * r.nextInt(3) , 1.0 );
        firefox.add( 2.0 , 1.0*r.nextInt(5) );
        firefox.add( 3.0 , 3.0 );
        final XYSeriesCollection result = new XYSeriesCollection();
        result.addSeries(firefox);
        return result;
    }

    /**
     * Creates a chart
     */
    private JFreeChart createChart(XYDataset dataset, String title) {

        JFreeChart chart = ChartFactory.createScatterPlot(
                title,
                "a",
                "b",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                false,
                false
        );
        return chart;
    }

    public void write(File file) throws IOException {
        ChartUtilities.saveChartAsPNG(file, this.chart, 500, 500);
    }

    public BufferedImage createBufferedImage() {
        return chart.createBufferedImage(500, 500);
    }
}