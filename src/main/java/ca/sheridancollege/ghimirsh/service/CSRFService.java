package ca.sheridancollege.ghimirsh.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import ca.sheridancollege.ghimirsh.beans.CSRFormat;

@Service
public class CSRFService {
	
	private CSRFormat temp;
	
//	@Bean
//	public CSRFormat prepareCSRFormat(CSRFormat obj) {
//		System.out.println("Testing CSRFService ...");
//		CSRFormat objCSRFormat = obj;
//		//objCSRFormat = obj;
//		
//		return objCSRFormat;
//	}
//	public void calclateVJI() {
//			
//	}
	
	public CSRFService() {
		
	}

	public CSRFormat testCSRFService(CSRFormat obj) {
		//System.out.println("CSRFService class testing....");
		System.out.println(obj.toString()); //for Testing
		temp = obj;	
		
		//calls method to fill Sparce Matrix elements
		fillMatrix(temp);
		
		//calls method to print matrix on console for testing purpose
		temp.printMatrix();
		
		//calls method that calculate the array V, J and I for the CSR format
		calculateVJI(temp);
		
		return temp;
	}
	
	public void fillMatrix(CSRFormat obj) {
		//Object to generate random number
		Random rand = new Random();
		
		double randValue = 0.0;
		
		//variable to hold threshhold value 
		double th = obj.getThresHold();
		
		//Creates a 2D array-matrix to hold sparce matrix elements as size specified by user
		double[][] mat = new double[obj.getRowSize()][obj.getColSize()];
		
		//code to fill every sparce matrix element
		//first for loop to generate row-value
		for (int i = 0; i < mat.length; i++) {
			
			//second for loop to generate column value in each row
			for (int j = 0; j < mat[i].length; j++) {
				//to generate random value
				randValue = Math.random();
				
				//To check the random value with the threshold value to convert to 0.0
				if (randValue < th) {
					mat[i][j] = 0.0;
				} else {
					
					
					//Code to round off the numbers upto 1 digit after decimal place
					double elementValue = Math.round(randValue * 100) / 10;
					//testVal = testVal / 10;
					//Generate random value either 0 or 1 and assigns the + or - sign in front of the number
					int randomValueForSign = rand.nextInt(2);
					if (randomValueForSign == 1) {
						mat[i][j] = -1 * elementValue;  //converts the value to negative
					} else {
						mat[i][j] = elementValue;
					}
				}
			}
		}
		obj.setMatrix(mat);
		//obj.printMatrix();
	}

	// method to calculate V, J and I
	private void calculateVJI(CSRFormat obj) {
		
		//Code to count total non-zero elements in the matrix
		int totalNonZeroElement = 0;
		for(int i = 0; i < obj.getMatrix().length; i++) {
			for(int j = 0; j < obj.getMatrix()[i].length; j++) {
				double temp = obj.getMatrix()[i][j];
				if(temp != 0.0) {
					totalNonZeroElement++;
				}
			}
		}
		
		//code to declare V, J and I array
		double[]tempArrV = new double[totalNonZeroElement];
		int [] tempArrJ = new int[totalNonZeroElement];
		int[] tempArrI = new int[obj.getRowSize() + 1];
		
		//Code to calculate V, J & I
		tempArrI[0] = 0;
		int count = 0;
		int index = 0;
		for(int i = 0; i < obj.getMatrix().length; i++) {
			for(int j = 0; j < obj.getMatrix()[i].length; j++) {
				double temp = obj.getMatrix()[i][j];
				if(temp != 0 ) {
					tempArrV[index] = temp;
					tempArrJ[index] = j;
					count++;
					index++;
				}
			}
			tempArrI[i+1] = count;
		}
		
		//for testing purpose
		System.out.println();
		System.out.print("V : ");
		for(double v: tempArrV) {
			System.out.print(v + ", ");
		}
		System.out.println();
		System.out.print("J : ");
		for(int j: tempArrJ) {
			System.out.print(j + ", ");
		}
		System.out.println();
		System.out.print("I : ");
		for(int i: tempArrI) {
			System.out.print(i + ", ");
		}
		System.out.println();
		
		//Assigning to object using setter methods
		obj.setArrV(tempArrV);
		obj.setArrJ(tempArrJ);
		obj.setArrI(tempArrI);
		
		
		//Creating List
		List<Double> tempListV = new ArrayList<>();
		List<Integer>tempListJ = new ArrayList<>();
		List<Integer>tempListI = new ArrayList<>();
		tempListI.add(0);
		int countElement = 0;
		for(int i = 0; i < obj.getMatrix().length; i++) {
			for(int j = 0; j < obj.getMatrix()[i].length; j++) {
				double temp = obj.getMatrix()[i][j];
				if(temp != 0 ) {
					tempListV.add(temp);
					tempListJ.add(j);				
					countElement++;
				}
			}
			tempListI.add(countElement);
		}
			
		//Assigning the tempList to Object
		obj.setListV(tempListV);
		obj.setListJ(tempListJ);
		obj.setListI(tempListI);
			
		//printing for testing purpose
		System.out.println("V: " + obj.getListV());
		System.out.println("J: " + obj.getListJ());
		System.out.println("I: " + obj.getListI());
		
	}
	
}
