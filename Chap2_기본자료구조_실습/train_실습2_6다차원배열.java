package Chap2_기본자료구조_실습;

/*
 * 3번째 실습
 * 교재 83 - 배열 처리 + function parameter 전달 숙달 훈련 
 *  함수에서 배열을 리턴할 때 리턴 타입 정의할 수 있어야 한다
 */

import java.util.Arrays;
import java.util.Random;

public class train_실습2_6다차원배열 {

	public static void main(String[] args) {
		int[][] A = new int[2][3];
		int[][] B = new int[3][4];
		int[][] C = new int[2][4];

		inputData(A);
		inputData(B);
		int[][] D = A.clone();// 교재83 - 배열 복제
		System.out.println("A[2][3] = ");
		showData("행렬 A", A);
		System.out.println("D[2][3] = ");
		showData("행렬 D", D);
		System.out.println();
		System.out.println("B[3][4] = ");
		showData("행렬 B", B);
		int[][] E = addMatrix(A, D);
		System.out.println("E[2][3] = ");
		showData("행렬 E", E);
		C = multiplyMatrix(A, B);
		System.out.println("C[2][4] = ");
		showData("행렬 C", C);
//
		int[][] F = transposeMatrix(B);
		System.out.println("F[4][3] = ");
		showData("행렬 F", F);
		C = multiplyMatrixTransposed(A, F);
		showData("행렬 곱셈 결과-전치행렬 사용", C);
	}

	static void inputData(int[][] data) {
		Random rand = new Random();
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				data[i][j] = rand.nextInt(20);
			}
		}
	}

	static void showData(String msg, int[][] items) {
		System.out.println(msg);
		for (int i = 0; i < items.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < items[0].length; j++) {
				System.out.print(items[i][j] + " ");
			}
			System.out.print("]");
			System.out.println();
		}
		System.out.println();
	}

//	static boolean equals(int[][]a, int[][]b) {
//
//
//	}
	static int[][] addMatrix(int[][] X, int[][] Y) {
		int[][] Z = new int[X.length][X[0].length];
		for (int i = 0; i < X.length; i++) {
			for (int j = 0; j < X[i].length; j++) {
				Z[i][j] = X[i][j] + Y[i][j];
			}
		}
		return Z;

	}

	static int[][] multiplyMatrix(int[][] X, int[][] Y) {
		int[][] Z = new int[X.length][Y[0].length];
		for (int i = 0; i < X.length; i++) {
			for (int j = 0; j < Y[0].length; j++) {
				for (int k = 0; k < Y.length; k++) {
					Z[i][j] += X[i][k] * Y[k][j];
				}
			}
		}
		return Z;

	}

	static int[][] transposeMatrix(int[][] X) {
		int[][] Y = new int[X[0].length][X.length];
		for (int i = 0; i < X.length; i++) {
			for (int j = 0; j < X[0].length; j++) {
				Y[j][i] = X[i][j];
			}
		}
		return Y;
	}

	static int[][] multiplyMatrixTransposed(int[][] X, int[][] Y) {
		int[][] Z = new int[X.length][Y.length];
		for (int i = 0; i < X.length; i++) {
			for (int j = 0; j < Y.length; j++) {
				for (int k = 0; k < X[0].length; k++) {
					Z[i][j] += X[i][k] * Y[j][k];
				}
			}
		}
		return Z;
	}
}
