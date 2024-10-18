import org.jfree.chart.ChartPanel;

import javax.swing.*;
import java.awt.*;

public class Display {
	public Display() {
		JFrame frame = new JFrame();
		frame.setTitle("Stats");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		frame.setVisible(true);

		Numset ns = new Numset();

		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(new GridLayout(2, 2));

		ChartPanel chartPanel = new ChartPanel(ns.getChart());
		panel.add(chartPanel);

		TablePanel tablePanel = new TablePanel(ns.getData());
		panel.add(tablePanel);

		StatsPanel statsPanel = new StatsPanel();
		panel.add(statsPanel);

		DetailsPanel detailsPanel = new DetailsPanel();
		panel.add(detailsPanel);

		panel.setVisible(true);
		panel.revalidate();
		panel.repaint();
	}
}
