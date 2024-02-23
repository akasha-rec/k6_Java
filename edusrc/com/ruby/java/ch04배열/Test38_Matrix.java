package com.ruby.java.ch04배열; // 자세한 가르침에 비한 어버버/...ㅠㅠ

import java.util.Random;

public class Test38_Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[][] = new int[3][4]; // 난수 입력
		int B[][] = new int[4][5]; // 난수 입력
		int C[][] = new int[3][5];
		int D[][] = new int[3][4]; // 난수 입력
		int E[][] = new int[3][4];
		int F[][] = new int[4][3];
		
		//합 입력식
		Random rnd  = new Random();// A, B random값 넣어줘야, C 초기화
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				A[i][j] = rnd.nextInt(100);
				D[i][j] = rnd.nextInt(100);
				E[i][j] = A[i][j]+D[i][j];
			}
		}
		// B 입력식
			for (int i = 0; i < 4; i++) {
				for (int j =0; j <5; j++) {
					B[i][j] = rnd.nextInt(100);
				}
			}
			//C 계산식 C = A*B
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				for(int k = 0; k < 4; k++) {
					C[i][j] += A[i][k] * B[k][j];
					}
				}
			}

		//합 출력
		for (int i = 0; i < 3; i++) { 
			for (int j = 0; j < 4; j++) {	
				System.out.print(E[i][j] + "\t");
			}
			System.out.println();
		}
		
		//곱 출력
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(C[i][j] + "\t");	
			}
			System.out.println();
			}
		
//		// F = A 전치 행렬
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <3 ; j++) {
				F[i][j] = A[j][i];
				System.out.print(F[i][j] + "\t");
				}
			System.out.println();
			}
		}
	}

		
		
