package model;

public interface SpreadsheetModel {
	void setFormula(String cell, String formula);
	String getValue(String cell);
}
