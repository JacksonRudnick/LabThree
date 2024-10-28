import javax.swing.*;

public class StatsPanel extends JPanel {
	Numset ns;

	JLabel meanLabel;
	JLabel stddevLabel;
	JLabel modeLabel;

	// Constructor
	StatsPanel(Numset nsIn) {
		ns = nsIn;

		// Add the labels
		meanLabel = new JLabel("Mean: " + ns.getMean());
		stddevLabel = new JLabel("Standard Deviation: " + ns.getStdDev());
		modeLabel = new JLabel("Mode: " + ns.getMode());

		this.add(meanLabel);
		this.add(stddevLabel);
		this.add(modeLabel);

		this.revalidate();
		this.repaint();
	}

	// Update the stats panel
	public void update() {
		meanLabel.setText("Mean: " + ns.getMean());
		stddevLabel.setText("Standard Deviation: " + ns.getStdDev());
		modeLabel.setText("Mode: " + ns.getMode());

		this.revalidate();
		this.repaint();
	}

}
