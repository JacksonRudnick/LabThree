import javax.swing.*;

public class TablePanel extends JPanel {
	String[] columnNames = {"Year", "All Food", "Food Away From Home", "Food At Home"};
	float[][] data = null;

	JTable table = null;
	JScrollPane scrollPane = null;

	int numRows = 50;
	int numCols = 4;

	TablePanel(float[][] data) {
		this.data = data;

		table = new JTable(data, columnNames);


		scrollPane = new JScrollPane(table);

		this.add(scrollPane);
	}
}
