package graphplot;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Shape;
import java.util.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.ShapeUtilities;

public class CopyOfSPlotfinal extends ApplicationFrame {

    public CopyOfSPlotfinal(String title, float[][] data) {
        super(title);
        JPanel jpanel = createDemoPanel(title, data);
        jpanel.setPreferredSize(new Dimension(640, 480));
        add(jpanel);
    }

    public static JPanel createDemoPanel(String title, float[][] data) {
        JFreeChart jfreechart = ChartFactory.createScatterPlot(
            title, "AGE", "INCOME( x 1000)", createDataSet(data),
            PlotOrientation.VERTICAL, true, true, false);
        
        Shape cross = ShapeUtilities.createDiagonalCross(3, 1);
        XYPlot xyPlot = (XYPlot) jfreechart.getPlot();
        xyPlot.setDomainCrosshairVisible(true);
        xyPlot.setRangeCrosshairVisible(true);
        XYItemRenderer renderer = xyPlot.getRenderer();
        renderer.setSeriesShape(0, cross);
        renderer.setSeriesPaint(0, Color.red);
        
        return new ChartPanel(jfreechart);
    }

    private static XYDataset createDataSet(float[][] data) {
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
        XYSeries series = new XYSeries("Cluster 1");
       
        for (int i = 0; i < data.length; i++) {               
                series.add(data[i][0], data[i][1]);           
        }
        
        xySeriesCollection.addSeries(series);
        return xySeriesCollection;
    }

    public static void main(String args[]) {
        /*SPlotfinal scatterplotdemo4 = new SPlotfinal("Scatter Plot Demo 4", new float[0][0]);
        scatterplotdemo4.pack();
        RefineryUtilities.centerFrameOnScreen(scatterplotdemo4);
        scatterplotdemo4.setVisible(true);*/
    }
}

