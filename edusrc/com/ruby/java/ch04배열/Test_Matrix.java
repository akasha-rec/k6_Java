package com.ruby.java.ch04배열; //

import java.util.Random;

public class Test_Matrix {
	/*
	 * 행렬 덧셈, 곱셈 연산 메소드 정의 1차버젼: 덧셈후 바로 출력 2차버젼: 덧셈후 return 값으로 결과 행렬 반환
	 */
	static void showMatrix(int[][] X) { //결과값 출력
		// 2차원 모습으로 출력
		for (int i = 0; i < X.length; i++) {
			for (int j = 0; j < X[0].length; j++) {
				System.out.print(X[i][j] + "\t");
			}
			System.out.println();
			
		}
		System.out.println();
	}

	static int[][] addMatrix(int[][] B, int[][] C) { //교수님이 가르쳐주신 정답

		int m[][];
		int r = B.length; // row
		int c = B[0].length;
		m = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				m[i][j] = B[i][j] + C[i][j];
			}
		}
		return m;
	}

	static int[][] multiplyMatrix(int[][]B, int[][]E){
		int M[][];
		int r = B.length;
		int c = E[0].length;
		int k = B[0].length;
		M = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				for (int l = 0; l < k; l++) {
				M[i][j] += B[i][l] * E[l][j];
				}
			}
		}
		return M;
	}
	
	static int[][] transposeMatrix(int [][]B){
		int X[][];
		int r = B.length;
		int c = B[0].length;
		X = new int[c][r];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				X[j][i] = B[i][j];
			}
		}
		return X;
	}

	static void getData(int[][] X) { //난수 생성
		Random rnd = new Random();
		for (int i = 0; i < X.length; i++)
			for(int j = 0; j < X[0].length; j++)
				X[i][j] = rnd.nextInt(10);
	}

	public static void main(String[] args) {
		/*
		 * 난수 생성으로 초기화 A[3][4] = B[3][4] + C[3][4]; D[3][5] = B[3][4] * E[4][5]; F[4][3]
		 * = B[3][4]의 전치 행렬
		 */
		Random rnd = new Random();
		int A[][] = new int[3][4];
		int B[][] = new int[3][4];
		int C[][] = new int[3][4];
		int D[][] = new int[3][5];
		int E[][] = new int[4][5];
		int F[][] = new int[4][3];

		System.out.println("행렬 더하기: A[3][4] = B[3][4] + C[3][4]");
		getData(B);
		getData(C);
		getData(E);
		A = addMatrix(B, C);


		showMatrix(B);
		showMatrix(C);
		showMatrix(A);
		System.out.println("행렬 곱하기: D[3][5] = B[3][4] * E[4][5]");
		D = multiplyMatrix(B, E);

		showMatrix(B);
		showMatrix(E);
		showMatrix(D);
		System.out.println("행렬 전치: F[4][3] = B[3][4]의 전치 행렬");
		F = transposeMatrix(B);
		showMatrix(B);
		showMatrix(F);

	}

}
