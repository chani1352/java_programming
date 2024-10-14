package Chap2_기본자료구조_실습;

/*
 * 2장 과제2 - 정수 배열 정렬
 * 배열의 크기는 20개, top 변수가 현재 배열에 저장된 갯수를 저장 
 */
import java.util.Arrays;
//교재 67 - 실습 2-5
//2번 실습
import java.util.Random;

public class train_실습2_5정수배열정렬 {
	static int top = 0;
	static final int MAX_LENGTH = 20;

	public static void main(String[] args) {
		float[] data = new float[MAX_LENGTH];// 0.0 ~ 1.0 사이의 실수를 저장
		inputData(data, 10);// 10개의 난수를 입력
		showData("실수 난수 입력", data);// top 개수 만큼 출력

		reverse(data);// 역순으로 재배치 - 교재 67페이지 참조
		showData("역순 재배치", data);
		System.out.println(Arrays.toString(data));// 교재 84페이지 코드 참조
		showData("실수 스트링의 정렬", data);
		sortData(data);// 교재 205 bubbleSort() 함수 코드를 사용 - 올림차순으로 정렬
		showData("버블정렬", data);
		float realData = (new Random()).nextFloat();
		insertData(data, realData);// 입력 실수보다 큰 숫자를 우측으로 이동
		System.out.print("realData :");
		System.out.println(realData);
		showData("실수 삽입후", data);
	}

	static void showData(String str, float[] arr) {// 실수 배열을 top 갯수만 출력
		System.out.print(str + "[" + arr[0]);
		for (int i = 1; i < top; i++) {
			System.out.print("," + arr[i]);
		}
		System.out.println("]");

	}

	static void inputData(float[] arr, int num) {
		// 난수 실수를 입력
		Random rand = new Random();
		int count = 1;
		for (int i = 0; i < num; i++) {
			arr[i] = rand.nextFloat();
			top += count;
		}

	}

	static void reverse(float[] arr) {// 역순으로 재배치 - top 갯수만 역순 재배치
		for (int i = 0; i < (top / 2); i++) {
			swap(arr, i, top - i - 1);
		}
	}

	static void swap(float[] arr, int i, int j) {// 교재 67페이지 - 맞교환
		float num = 0;
		num = arr[i];
		arr[i] = arr[j];
		arr[j] = num;
	}

	static void sortData(float[] arr) {// 올림차순으로 정렬 - top 갯수를 사용
		for (int i = 0; i < top - 1; i++) {
			for (int j = 0; j < top - 1; j++) {
				if (arr[top - j - 1] < arr[top - j - 2])
					swap(arr, top - j - 1, top - j - 2);
			}

		}
	}

	static void insertData(float[] arr, float num) {// insert되는 실수 값이 insert될 위치를 찾아 보다 큰 값은 우측으로 이동
		for (int i = 0; i < top; i++) {
			if (arr[top - i - 1] > num) {
				arr[top - i] = arr[top - i - 1];
				if (i == (top-1)) arr[0] = num;
			} else {
				arr[top - i] = num;
				break;
			}
		}
		top++;
	}

}
