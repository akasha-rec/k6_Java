package Data_Structure;

/*
 * 3번째 실습
 * 교재 83 - 배열 처리
 */

import java.util.Arrays;
import java.util.Random;
public class Dimensional_Array {

	public static void main(String[] args) {
		int [][]A = new int[2][3];
		int [][]B = new int[3][4];
		int [][]C = new int[2][4];

		inputData(A);inputData(B);
		int [][]D = A.clone();//교재83 - 배열 복제
		System.out.println("A[2][3] = ");
		showData(A);
		System.out.println("D[2][3] = ");
		showData(D);
		System.out.println();
		System.out.println("B[3][4] = ");
		showData(B);
		int [][]E = addMatrix(A,D);
		System.out.println("E[2][3] = ");
		showData(E);
		C = multiplyMatrix(A,B);
		System.out.println("C[2][4] = ");
		showData(C);

		int [][]F = transposeMatrix(A);
		System.out.println("F[3][2] = ");
		showData(F);
		boolean result = equals(A, D);
		System.out.println(" equals(A,D) = " + result);

		System.out.println("F = " + Arrays.deepToString(F));//2차원 배열 처리 
	}

	static void inputData(int [][]data) {
		Random rnd = new Random();
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data.length; j++) {
				data[i][j] = rnd.nextInt(10);
			}
	}
	static void showData(int[][]items) {
		for (int[] row : items) {
			for (int item : row) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static boolean equals(int[][]a, int[][]b) {
		if (a.length != b.length || a[0].length != b[0].length) //두 행렬의 행 길이가 같지 않거나 열의 길이가 같지 않으면
			return false; // 같지 않다
		else
			return true; // 같다
	}

	static int[][] addMatrix(int [][]X, int[][]Y) {
		int rows = X.length;
		int cols = X[0].length;
		int [][]Z = new int[rows][cols];
		// Z = X + Y
		for (int i = 0; i < X.length; i++)
			for (int j = 0; j < X[0].length; j++) {
				Z[i][j] = X[i][j] + Y[i][j];
			}

		return Z;
	}

	static int[][] multiplyMatrix(int [][]X, int[][]Y) {
		int rows = X.length;
		int cols = Y[0].length;
		int [][]Z = new int[rows][cols];
		for (int i = 0; i < X.length; i++) {
			for (int j = 0; j < Y[0].length; j++) {
				for (int k = 0; k < X.length; k++) {
					Z[i][j] += X[i][k] * Y[k][j];
				}
			}
		}
		
		return Z;
	}
	
	static int[][] transposeMatrix(int [][]X) {
		int rows = X.length;
		int cols = X[0].length;
		int [][]Z = new int[cols][rows];
		for (int i = 0; i < X.length; i++)
			for (int j = 0; j < X[0].length; j++) {
				Z[j][i] = X[i][j];
			}
		return Z;

	}
}

