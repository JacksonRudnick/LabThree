import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class TablePanel extends JPanel {
	Numset ns = null;
	JTable table = null;
	JScrollPane scrollPane = null;
	DefaultTableModel model = null;
	TableRowSorter<TableModel> sorter = null;

	// Filters
	JCheckBox treatedFilter = null;
	JCheckBox untreatedFilter = null;
	JCheckBox manFilter = null;
	JCheckBox womanFilter = null;

	TablePanel(Numset nsIn, StatsPanel statsPanel, DetailsPanel detailsPanel) {
		// Set the layout
		this.setMinimumSize(new Dimension(400, 400));
		this.setLayout(new BorderLayout());

		// Create the filter panel
		JPanel filterPanel = new JPanel();

		treatedFilter = new JCheckBox("Filter Treated Out");
		untreatedFilter = new JCheckBox("Filter Untreated Out");
		manFilter = new JCheckBox("Filter Men Out");
		womanFilter = new JCheckBox("Filter Women Out");

		filterPanel.add(treatedFilter);
		filterPanel.add(untreatedFilter);
		filterPanel.add(manFilter);
		filterPanel.add(womanFilter);

		this.add(filterPanel, BorderLayout.NORTH);

		// Set the Numset
		ns = nsIn;

		table = new JTable(ns.getData(), ns.getColNames());

		// Make table uneditable
		model = new DefaultTableModel(ns.getData(), ns.getColNames()) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// set the model to the table
		table.setModel(model);

		// Enable sorting
		sorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(sorter);

		// Add filters
		treatedFilter.addActionListener(e -> {
			if (treatedFilter.isSelected()) {
				sorter.setRowFilter(RowFilter.regexFilter("^0$", 10));
			} else {
				sorter.setRowFilter(null);
			}
		});

		untreatedFilter.addActionListener(e -> {
			if (untreatedFilter.isSelected()) {
				sorter.setRowFilter(RowFilter.regexFilter("^(?!0$)\\d+$", 10));
			} else {
				sorter.setRowFilter(null);
			}
		});

		manFilter.addActionListener(e -> {
			if (manFilter.isSelected()) {
				sorter.setRowFilter(RowFilter.regexFilter("^1$", 5));
			} else {
				sorter.setRowFilter(null);
			}
		});

		womanFilter.addActionListener(e -> {
			if (womanFilter.isSelected()) {
				sorter.setRowFilter(RowFilter.regexFilter("^0$", 5));
			} else {
				sorter.setRowFilter(null);
			}
		});

		// Add a mouse listener to the table
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int col = table.columnAtPoint(evt.getPoint());
				int row = table.rowAtPoint(evt.getPoint());

				ns.selectCol(col);
				statsPanel.update();
				detailsPanel.update("Selected column: " + ns.getColNames()[col], "Selected Row: " + row);
			}
		});

		scrollPane = new JScrollPane(table);

		this.add(scrollPane, BorderLayout.CENTER);
	}
}
