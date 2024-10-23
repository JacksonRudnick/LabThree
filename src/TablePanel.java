import javax.swing.*;

public class TablePanel extends JPanel {
	String[] columnNames = {"Year", "All Food", "Food Away From Home", "Food At Home"};
	Object[][] data = null;

	JTable table = null;
	JScrollPane scrollPane = null;

	int numRows = 50;
	int numCols = 4;

	TablePanel(float[][] data) {
		this.data = new Object[data.length][data[0].length];
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				this.data[i][j] = data[i][j]; // Autoboxing from float to Float
			}
		}

		table = new JTable(this.data, columnNames);

		scrollPane = new JScrollPane(table);

		this.add(scrollPane);
	}
}
