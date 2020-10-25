package ca.sheridancollege.ghimirsh.service;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import ca.sheridancollege.ghimirsh.beans.CSRFormat;

@Service
public class CSRFService {
	
	//@Autowired
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
		System.out.println(obj.toString());
		temp = obj;
		
		fillMatrix(temp);
		temp.printMatrix();
		calculateVJI(temp);
		
		return temp;
	}
	
	public void fillMatrix(CSRFormat obj) {
		Random rand2 = new Random();
		double randValue = 0.0;
		double th = obj.getThresHold();
		double[][] mat = new double[obj.getRowSize()][obj.getColSize()];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				randValue = Math.random();
				if (randValue < th) {
					mat[i][j] = 0.0;
				} else {
					int val2 = rand2.nextInt(2);
					double testVal = Math.round(randValue * 100);
					testVal = testVal / 10;
					if (val2 == 1) {
						mat[i][j] = -1 * testVal;
					} else {
						mat[i][j] = testVal;
					}

				}
				// mat[i][j] = Math.random();
			}
		}
		obj.setMatrix(mat);
		//obj.printMatrix();
	}

	// method to calculate V, J and I
	private void calculateVJI(CSRFormat obj) {
		
		obj.setArrI(0);
		int count = 0;
		for(int i = 0; i < obj.getMatrix().length; i++) {
			for(int j = 0; j < obj.getMatrix()[i].length; j++) {
				double temp = obj.getMatrix()[i][j];
				if(temp != 0 ) {
					obj.setArrV(temp);
					obj.setArrJ(j);
					count++;
				}
			}
			obj.setArrI(count);
		}
		
		//print V, J and I
		System.out.println();
		System.out.println("V: " + obj.getArrV());
		System.out.println("J: " + obj.getArrJ());
		System.out.println("I: " +  obj.getArrI());
	}

	
	
	
	
}
