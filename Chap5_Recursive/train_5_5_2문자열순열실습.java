package Chap5_Recursive;

public class train_5_5_2문자열순열실습 {
	static int count = 0;
	static int num = 0;

	// 주어진 문자 배열의 순열을 생성하는 함수
	public static void permutate(char[] arr, int index) {

		for (int j = 0; j < 3; j++) {
			swap(arr, 0, 1);
			System.out.println(String.valueOf(arr));
			count++;
			swap(arr, 1, 2);
			System.out.println(String.valueOf(arr));
			count++;
		}
		
		
		num = arr.length-3;
		for(int i = 1 ; i <= num ; i++ ) {
			if (index < 2+i) {
				swap(arr, index, 2+i);
				permutate(arr, index + 1);
				swap(arr, index, 2+i);
			}
		}
	}

	// 두 요소를 교환하는 함수
	public static void swap(char[] arr, int i, int j) {
		char sw = arr[i];
		arr[i] = arr[j];
		arr[j] = sw;
	}

	public static void main(String[] args) {
		// 문자열을 문자 배열로 변환
		String l = "abce";
		char[] arr = l.toCharArray();

		// 순열 생성 및 출력
		permutate(arr, 0);
		System.out.println(count);
	}
}
