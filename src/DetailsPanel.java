import javax.swing.*;

public class DetailsPanel extends JPanel {
	DetailsPanel() {
	}

	// Update the details panel
	public void update(String colDetails, String rowDetails) {
		this.removeAll();

		JLabel colLabel = new JLabel(colDetails);
		JLabel rowLabel = new JLabel(rowDetails);

		this.add(colLabel);
		this.add(rowLabel);

		this.revalidate();
		this.repaint();
	}
}
