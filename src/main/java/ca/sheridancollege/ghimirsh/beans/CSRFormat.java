package ca.sheridancollege.ghimirsh.beans;

import java.util.Arrays;
import java.util.List;

public class CSRFormat {
	private boolean readFromFile;
	private int rowSize;
	private int colSize;
	private double minRange;
	private double maxRange;
	private List<Integer> arrV;
	private List<Integer> arrJ;
	private List<Integer> arrI;
	private String userOption;
	
	private String[] availableOptions = {"-Choose an Option-","V", "J","I"};
	public CSRFormat() {
		super();
	}
	public CSRFormat(boolean readFromFile, int rowSize, int colSize, double minRange, double maxRange,
			List<Integer> arrV, List<Integer> arrJ, List<Integer> arrI, String userOption, String[] availableOptions) {
		super();
		this.readFromFile = readFromFile;
		this.rowSize = rowSize;
		this.colSize = colSize;
		this.minRange = minRange;
		this.maxRange = maxRange;
		this.arrV = arrV;
		this.arrJ = arrJ;
		this.arrI = arrI;
		this.userOption = userOption;
		this.availableOptions = availableOptions;
	}
	public boolean isReadFromFile() {
		return readFromFile;
	}
	public void setReadFromFile(boolean readFromFile) {
		this.readFromFile = readFromFile;
	}
	public int getRowSize() {
		return rowSize;
	}
	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}
	public int getColSize() {
		return colSize;
	}
	public void setColSize(int colSize) {
		this.colSize = colSize;
	}
	public double getMinRange() {
		return minRange;
	}
	public void setMinRange(double minRange) {
		this.minRange = minRange;
	}
	public double getMaxRange() {
		return maxRange;
	}
	public void setMaxRange(double maxRange) {
		this.maxRange = maxRange;
	}
	public List<Integer> getArrV() {
		return arrV;
	}
	public void setArrV(List<Integer> arrV) {
		this.arrV = arrV;
	}
	public List<Integer> getArrJ() {
		return arrJ;
	}
	public void setArrJ(List<Integer> arrJ) {
		this.arrJ = arrJ;
	}
	public List<Integer> getArrI() {
		return arrI;
	}
	public void setArrI(List<Integer> arrI) {
		this.arrI = arrI;
	}
	public String getUserOption() {
		return userOption;
	}
	public void setUserOption(String userOption) {
		this.userOption = userOption;
	}
	public String[] getAvailableOptions() {
		return availableOptions;
	}
	public void setAvailableOptions(String[] availableOptions) {
		this.availableOptions = availableOptions;
	}
	@Override
	public String toString() {
		return "CSRFormat [readFromFile=" + readFromFile + ", rowSize=" + rowSize + ", colSize=" + colSize
				+ ", minRange=" + minRange + ", maxRange=" + maxRange + ", arrV=" + arrV + ", arrJ=" + arrJ + ", arrI="
				+ arrI + ", userOption=" + userOption + ", availableOptions=" + Arrays.toString(availableOptions) + "]";
	}
		
}
