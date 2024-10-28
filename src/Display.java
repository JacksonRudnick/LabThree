import org.jfree.chart.ChartPanel;

import javax.swing.*;
import java.awt.*;

public class Display {
	public Display() {
		JFrame frame = new JFrame();
		frame.setTitle("Stats");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1280, 720);
		frame.setVisible(true);

		Numset ns = new Numset();

		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(new GridLayout(2, 2));

		ChartPanel chartPanel = new ChartPanel(ns.getChart());
		panel.add(chartPanel);

		StatsPanel statsPanel = new StatsPanel(ns);
		panel.add(statsPanel);

		DetailsPanel detailsPanel = new DetailsPanel();
		panel.add(detailsPanel);

		TablePanel tablePanel = new TablePanel(ns, statsPanel, detailsPanel);
		panel.add(tablePanel);

		panel.setVisible(true);
		panel.revalidate();
		panel.repaint();
	}
}

class Main {
	public static void main(String[] args) {
		Display display = new Display();
	}
}
