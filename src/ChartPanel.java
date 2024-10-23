import org.jfree.chart.JFreeChart;
import javax.swing.*;

public class ChartPanel extends JPanel {
	JFreeChart chart;

	ChartPanel(JFreeChart chart) {
		this.chart = chart;

		this.add(new org.jfree.chart.ChartPanel(chart));
	}

}
