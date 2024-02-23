package com.ruby.java.ch04배열;

import java.util.Random;

public class Test38 {

	public static void main(String[] args) { //대각선이 안 돼..
		// TODO Auto-generated method stub
		int arr[][] = new int[5][5];
		Random rnd = new Random();
		for (int i = 0; i < arr.length; i++)
			for(int j = 0; j < arr[0].length; j++)
				arr[i][j] = rnd.nextInt(500);
		for (int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if (i == j)
					System.out.println(arr[i][j] + "\t");
			}
			System.out.println();	
		}
	}
}
	
//		System.out.println("행의 개수 : " + arr.length);; //행의 길이
//		System.out.println("열의 개수 : " + arr[0].length); //열의 길이
		
//		int arr2[][] = {{1,2}, {3,4,7,8}, {5,6,9}}; //ragged array - 코딩 주의 필요

