import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.io.*;

class Numset {
	JFreeChart chart;

	final int startYear = 1974;
	final int numLines = 50;
	final int numData = 4;
	float[][] data;

	//all food
	float mean;
	float stddev;

	public Numset() {
		data = new float[numLines][numData];
		Scanner sc = null;

		//scanner for file
		try {
			sc = new Scanner(new File("info.csv"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return;
		}

		//use comma for limiter
		sc.useDelimiter(",");

		//skip first line containing outline for vars
		sc.nextLine();

		for (int i = 0; i < numLines; i++) {
			//read data
			data[i][0] = Integer.parseInt(sc.next());
			data[i][1] = Float.parseFloat(sc.next());
			data[i][2] = Float.parseFloat(sc.next());
			data[i][3] = Float.parseFloat(sc.next());
			sc.nextLine();
		} //all data is read

		//select default column
		selectCol(1);

		//create chart
		chart = ChartFactory.createXYLineChart("Cpi of Food Prices Over Time", "Year", "Value", getDataset(1));
	}

	public void selectCol(int col) {
		if (col == 0 || col > 3) {
			System.out.println("Invalid Column");
			return;
		}

		mean = 0;
		stddev = 0;

		//go through years
		for (int i = 0; i < numLines; i++) {
			mean += data[i][col];
		}

		mean /= numLines;
		stddev = mean / numLines;

		getDataset(col);
	}

	public JFreeChart getChart() {
		return chart;
	}

	private XYSeries returnSeries(int col) {
		XYSeries series = new XYSeries(numLines);

		if (col == 0 || col > 3) {
			System.out.println("Invalid Column");
			return null;
		}

		for (int i = 0; i < numLines; i++) {
			series.add(data[i][0], data[i][col]);
		}

		return series;
	}

	private XYDataset getDataset(int col) {
		XYSeriesCollection dataset = new XYSeriesCollection();

		dataset.addSeries(returnSeries(col));

		chart = ChartFactory.createXYLineChart("Cpi of Food Prices Over Time", "Year", "Value", dataset);

		return dataset;
	}

	public float[][] getData() {
		return data;
	}

	public float getMean() {
		return mean;
	}

	public float getStddev() {
		return stddev;
	}
}