package com.ruby.java.ch06; //2월 13일

public class Test {
	int [][] mA = {//3 * 4
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12}	
	};
	
	int [][] mB = {//4 * 3 
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9},
			{10, 11, 12}
	};
	int [][] mR = new int[3][3];
	//Integer [][] mR = new Integer[][]; 차이?
	
	public void multiple() {
		for (int i = 0; i < 3; i++) // mA 행
			for (int j = 0; j < 3; j++) // mB 열
				for (int k = 0; k < 4; k++)  // 더해지는 횟수
					mR[i][j] += mA[i][k]*mB[k][j];
	}
	public void print() {
		for (int i = 0; i < mR.length; i++) {
			for (int j = 0; j < mR[0].length; j++) {
				System.out.print(mR[i][j] + "\t");
			}
			System.out.println(); // 한 라인 내린다?
		}
	}
	
	public static void main(String[] args) {
		
		Test t1 = new Test();
		t1.multiple();
		t1.print();
	}

}
