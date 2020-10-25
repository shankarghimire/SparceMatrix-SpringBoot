package ca.sheridancollege.ghimirsh.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSRFormat {
	private boolean readFromFile;
	private int rowSize;
	private int colSize;
	private double [][]matrix;
	private double thresHold;
	
	private List<Double> arrV = new ArrayList<>();
	private List<Integer> arrJ = new ArrayList<>();
	private List<Integer> arrI = new ArrayList<>();
	private String userOption;
	
	private String[] availableOptions = {"-Choose an Option-","V", "J","I"};
	public CSRFormat() {
		
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
	
	public double getThresHold() {
		return thresHold;
	}

	public void setThresHold(double thresHold) {
		this.thresHold = thresHold;
	}

	public List<Double> getArrV() {
		return arrV;
	}
	public void setArrV(Double e) {
		this.arrV.add(e);
		//this.arrV;
	}
	public List<Integer> getArrJ() {
		return arrJ;
	}
	public void setArrJ(Integer arrJ) {
		this.arrJ.add(arrJ);
	}
	public List<Integer> getArrI() {
		return arrI;
	}
	public void setArrI(Integer arrI) {
		this.arrI.add(arrI);
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


	public double[][] getMatrix() {
		return matrix;
	}


	public void setMatrix(double[][] matrix) {
		this.matrix = matrix;
	}

	public void printMatrix() {
		System.out.println("Auto-generated sparce matrix : ");
		System.out.println();
		for(int row = 0; row < matrix.length; row++) {
			for(int col = 0; col < matrix[row].length; col++) {
				System.out.printf("%7.1f",matrix[row][col]);
			}
			System.out.println();
		}
		System.out.println();
	}


	@Override
	public String toString() {
		return "CSRFormat [readFromFile=" + readFromFile + ", rowSize=" + rowSize + ", colSize=" + colSize + ", matrix="
				+ Arrays.toString(matrix) + ", thresHold=" + thresHold + ", arrV=" + arrV + ", arrJ=" + arrJ + ", arrI="
				+ arrI + ", userOption=" + userOption + ", availableOptions=" + Arrays.toString(availableOptions) + "]";
	}



	
	
		
}
