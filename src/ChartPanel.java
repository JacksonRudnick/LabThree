import org.jfree.chart.JFreeChart;
import javax.swing.*;

public class ChartPanel extends JPanel {
	JFreeChart chart;

	ChartPanel(JFreeChart chart) {
		this.chart = chart;

		// Add the chart to the panel
		this.add(new org.jfree.chart.ChartPanel(chart));
	}
}
