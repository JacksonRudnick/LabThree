import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

class Numset {
	JFreeChart chart;

	String[][] data;
	String[] colNames;
	int numLines;

	float mean;
	float stddev;
	float mode;

	int voterCol = 6;

	public Numset() {
		Scanner sc = null;

		//NEED TO LOOK AT USING A STREAM FOR DATA!!!!!!!

		//scanner for file
		try {
			sc = new Scanner(new File("UDADHF_replication.csv"));
		} catch (FileNotFoundException e) {
			System.out.println("Error reading file.");
			return;
		}

		//get number of lines
		try {
			numLines = (int) Files.lines(Paths.get("UDADHF_replication.csv")).count()-1;
			data = new String[numLines][];
		} catch (IOException e) {
			System.out.println("Error reading file.");
			return;
		}

		//Get column names
		colNames = sc.nextLine().split(",");

		int row = 0;
		while (sc.hasNextLine()) {
			//split line by commas
			data[row] = sc.nextLine().split(",");
			row++;
		}

		sc.close();

		//select default column
		selectCol(0);

		//get number of people who voted
		int voted = 0;
		int missing = 0;
		for (int i = 0; i < numLines-1; i++) {
			int temp = 0;

			try {
				temp = Integer.parseInt(data[i][voterCol]);
			} catch (NumberFormatException e) {
				//did not wish to say whether they voted
				missing++;
				continue;
			}

			if (temp == 1) {
				voted++;
			}
		}

		//create pie chart
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Voted", voted);
		dataset.setValue("Did not vote", numLines - voted - missing);
		dataset.setValue("Did not wish to say", missing);

		chart = ChartFactory.createPieChart("Voter Turnout", dataset, true, true, false);
	}

	public void selectCol(int col) {
		HashMap<Float, Integer> tempHash = new HashMap<>();

		mean = 0;
		stddev = 0;

		try {
			Float.parseFloat(data[0][col]);
		} catch (NumberFormatException e) {
			System.out.println("NonFloat Column");
			//get out of function so we don't waste processing
			return;
		}

		//go through years
		for (int i = 0; i < numLines; i++) {
			float temp = 0;

			try {
				temp = Float.parseFloat(data[i][col]);
			} catch (NumberFormatException e) {
				//empty string, skip to next row
				continue;
			}

			mean += temp;
			tempHash.put(temp, tempHash.getOrDefault(temp, 0)+1);
		}

		//map to find mode of data
		mode = tempHash.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();

		mean /= numLines;
		stddev = mean / numLines;
	}

	public JFreeChart getChart() {
		return chart;
	}

	public String[] getColNames() {
		return colNames;
	}

	public String[][] getData() {
		return data;
	}

	public float getMean() {
		return mean;
	}

	public float getStdDev() {
		return stddev;
	}

	public float getMode() {
		return mode;
	}
}