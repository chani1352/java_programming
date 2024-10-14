package Chap2_기본자료구조_실습;

/*
 * 2장 실습과제4 - 스트링 배열 정렬
 * 정렬된 배열에 insert하면 중간에 끼워 넣으면 큰 값들은 이동해야 하고 크기를 1 증가 처리가 필요 
 */
public class Train_실습2_14스트링배열정렬 {
	public static void main(String[] args) {
		String[] data = { "apple", "grape", "persimmon", "pear", "blueberry", "strawberry", "melon", "oriental melon" };

		showData("정렬전", data);
		sortData(data);
		showData("정렬후", data);
		String[] newData = insertString(data, "banana");
		showData("삽입후 크기가 증가된 정렬 배열", newData);

	}

	static void showData(String str, String[] arr) {// 확장된 for 문으로 출력
		System.out.println(str);
		for (String item : arr) {
			System.out.print(item + " ");
		}
		System.out.println();
	}

//
//	swap() {//스트링의 맞교환 함수로 sortData()에서 호출됨
//		
//	}
	static void sortData(String[] arr) {// 올림차순으로 정렬 - for 문을 사용하여 직접 구현한다
		String str = "";
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 01; j++) {
				if (arr[j].compareTo(arr[j + 1]) > 0) {
					str = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = str;
				}
			}

		}
	}

	static String[] insertString(String[] arr, String str) {// 배열의 사이즈를 1개 증가시킨후 insert되는 스트링 보다 큰 값들은 우측으로 이동, 사이즈가 증가된
															// 스트링 배열을 리턴
		String[] newArr = new String[arr.length + 1];
//		for(int i = 0 ; i < arr.length ; i++) {
//			newArr[i] = arr[i];
//		}
//		for(int i = 0 ; i < arr.length ; i++) {
//			if(arr[arr.length-i-1].compareTo(str) > 0) {
//				newArr[arr.length-i] = arr[arr.length-i-1];
////				if(i == (arr.length-1)) newArr[0] = str;
//			}else {
//				newArr[arr.length-i] = str;
//				break;
//			}
//		}
		int num = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].compareTo(str) < 0) {
				newArr[i] = arr[i];
			} else {
				newArr[i] = str;
				num = i;
				break;
			}
		}
		for (int i = num; i < arr.length ; i++) {
			newArr[i+1] = arr[i];
		}
		return newArr;
	}
}
