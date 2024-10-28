import javax.swing.*;

public class StatsPanel extends JPanel {
	Numset ns;

	JLabel meanLabel;
	JLabel stddevLabel;
	JLabel modeLabel;

	StatsPanel(Numset nsIn) {
		ns = nsIn;

		meanLabel = new JLabel("Mean: " + ns.getMean());
		stddevLabel = new JLabel("Standard Deviation: " + ns.getStdDev());
		modeLabel = new JLabel("Mode: " + ns.getMode());

		this.add(meanLabel);
		this.add(stddevLabel);
		this.add(modeLabel);

		this.revalidate();
		this.repaint();
	}

	public void update() {
		meanLabel.setText("Mean: " + ns.getMean());
		stddevLabel.setText("Standard Deviation: " + ns.getStdDev());
		modeLabel.setText("Mode: " + ns.getMode());

		this.revalidate();
		this.repaint();
	}

}
