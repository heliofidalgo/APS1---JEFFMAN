package controller;
import javax.swing.JFrame;

import model.SpreadsheetModel;
import view.Spreadsheet;

public class CalcMachine {

	public static void main(String[] args) {
		(new CalcMachine()).run();
	}

	private void run() {
		SpreadsheetModel m = new SpreadsheetModel() {
			public void setFormula(String cell, String formula) {
				System.out.println(formula);
			}
			
			public String getValue(String cell) {
				return String.format("%06g", Math.random()*100 - 50);
			}
		};
		
		JFrame window = new Spreadsheet(m);
		window.pack();
		window.setVisible(true);
	}
}
