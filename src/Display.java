import javax.swing.*;
import java.awt.*;

public class Display {
	public Display() {
		JFrame frame = new JFrame();
		frame.setTitle("Stats");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(new GridLayout(2, 2));

		ChartPanel chartPanel = new ChartPanel();
		panel.add(chartPanel);

		TablePanel tablePanel = new TablePanel();
		panel.add(tablePanel);

		StatsPanel statsPanel = new StatsPanel();
		panel.add(statsPanel);

		DetailsPanel detailsPanel = new DetailsPanel();
		panel.add(detailsPanel);

		panel.setVisible(true);
	}
}
