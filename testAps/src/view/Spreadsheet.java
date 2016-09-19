package view;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import model.SpreadsheetModel;

public class Spreadsheet extends JFrame {
	private static final long serialVersionUID = 6096182290678671725L;

	public Spreadsheet(SpreadsheetModel spreadsheet) {
		super("Spreadsheet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTable table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		view.SpreadsheetTableModel model = new view.SpreadsheetTableModel(spreadsheet);
		table.setModel(model);

		TableColumnModel cols = table.getColumnModel();
		
		cols.getColumn(0).setPreferredWidth(50);
		cols.getColumn(0).setCellRenderer(new RowNumberRenderer());
		
		for (int i = 1; i < cols.getColumnCount(); i++) {
			DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
			rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
			cols.getColumn(i).setCellRenderer(rightRenderer);
			cols.getColumn(i).setPreferredWidth(100);
		}
		
		add(scroll);
	}

    private class RowNumberRenderer extends DefaultTableCellRenderer {   
		private static final long serialVersionUID = -4374802697902545484L;

		public RowNumberRenderer()
        {
            setHorizontalAlignment(JLabel.CENTER);
        }

        public Component
        	getTableCellRendererComponent(
        			JTable table, Object value,
        			boolean isSelected, boolean hasFocus,
        			int row, int column) 
        {
            if (table != null) {
                JTableHeader header = table.getTableHeader();

                if (header != null) {
                    setForeground(header.getForeground());
                    setBackground(header.getBackground());
                    setFont(header.getFont());
                }
            }

            if (isSelected) {
                setFont( getFont().deriveFont(Font.BOLD) );
            }

            setText((value == null) ? "" : value.toString());
            setBorder(UIManager.getBorder("TableHeader.cellBorder"));

            return this;
        }
    }
}
