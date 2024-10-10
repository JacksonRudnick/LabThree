import java.util.Scanner;
import java.io.*;

class Numset {
	int numLines = 50;
	YearInfo[] data;

	//all food
	float mean;
	float stddev;

	public Numset() {
		Scanner sc = null;

		//scanner for file
		try {
			sc = new Scanner(new File("info.csv"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return;
		}

		//50 years of data
		data = new YearInfo[numLines];

		//use comma for limiter
		sc.useDelimiter(",");

		//skip first line containing outline for vars
		sc.nextLine();

		for (int i = 0; i < data.length; i++) {
			//read data
			int year = Integer.parseInt(sc.next());
			float af = Float.parseFloat(sc.next());
			float fafh = Float.parseFloat(sc.next());
			float fah = Float.parseFloat(sc.next());
			float mpf = Float.parseFloat(sc.next());
			float dp = Float.parseFloat(sc.next());

			data[i] = new YearInfo(year, af, fafh, fah, mpf, dp);
			sc.nextLine();
		} //all data is in records by now

		selectCol(1);

		System.out.println("Mean: " + mean);
		System.out.println("StdDev: " + stddev);
	}

	public void selectCol(int col) {
		mean = 0;
		stddev = 0;

		switch (col) {
			case 1:
				for (YearInfo datum : data) {
					mean += datum.af();
				}
				break;
			case 2:
				for (YearInfo datum : data) {
					mean += datum.fafh();
				}
				break;
			case 3:
				for (YearInfo datum : data) {
					mean += datum.fah();
				}
				break;
			case 4:
				for (YearInfo datum : data) {
					mean += datum.mpf();
				}
				break;
			case 5:
				for (YearInfo datum : data) {
					mean += datum.dp();
				}
				break;
			default:
				System.out.println("Invalid column number");
				return;
		}

		mean /= data.length;
		stddev = mean / data.length;
	}

	public float getMean() {
		return mean;
	}

	public float getStddev() {
		return stddev;
	}
}