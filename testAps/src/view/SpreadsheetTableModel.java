package view;

import javax.swing.table.AbstractTableModel;

import model.SpreadsheetModel;

public class SpreadsheetTableModel extends AbstractTableModel {
	private static final long serialVersionUID = -7623344886451021182L;
	private SpreadsheetModel spreadsheet;

	public SpreadsheetTableModel(SpreadsheetModel spreadsheet) {
		this.spreadsheet = spreadsheet;
	}
	
	public int getRowCount() {
		return 100;
	}

	public int getColumnCount() {
		return 40;
	}

	private String translateIndexToColumnName(int index) {
		index--;
		String name = "";
		int b = 26;
		while (b <= index) {
			name = (char)(65 + (index % b)) + name;
			index /= b;
			index--;
		}
		name = (char)(65 + (index % b)) + name;
		return name;
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex > 0) {
			return spreadsheet.getValue(translateIndexToColumnName(columnIndex - 1));
		}
		return rowIndex+1;
	}

	@Override
	public void setValueAt(Object o, int rowIndex, int columnIndex) {
		if (columnIndex > 0) {
			// set data
			String name = translateIndexToColumnName(columnIndex-1);			
			name += rowIndex;
			spreadsheet.setFormula(name, o.toString());
		}
	}

	@Override
	public String getColumnName(int index) {
		if (index == 0)
			return " ";
		return translateIndexToColumnName(index);
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		if (column >  0)
			return true;
		return false;
	}
	
}
