import org.jfree.chart.ChartPanel;

import javax.swing.*;
import java.awt.*;

public class Display {

	// Constructor
	public Display() {
		// Create the frame
		JFrame frame = new JFrame();
		frame.setTitle("Stats");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1280, 720);
		frame.setVisible(true);

		// Create the Numset
		Numset ns = new Numset();

		// Create the layout panel
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(new GridLayout(2, 2));

		// Create the chart panel
		ChartPanel chartPanel = new ChartPanel(ns.getChart());
		panel.add(chartPanel);

		// Create the stats panel
		StatsPanel statsPanel = new StatsPanel(ns);
		panel.add(statsPanel);

		// Create the details panel
		DetailsPanel detailsPanel = new DetailsPanel();
		panel.add(detailsPanel);

		// Create the table panel
		TablePanel tablePanel = new TablePanel(ns, statsPanel, detailsPanel);
		panel.add(tablePanel);

		// Setup main panel
		panel.setVisible(true);
		panel.revalidate();
		panel.repaint();
	}
}

// Class to run program
class Main {
	public static void main(String[] args) {
		Display display = new Display();
	}
}
