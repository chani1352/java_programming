package chap1_기본알고리즘_실습;

public class 실습1_5_숫자변환_과제 {
	
	public static String[] splitSortString(String str) {
		String[] array = str.split(" ");
		return array;
	}
	
	public static void printStringArray(String[] str) {
		for (String item : str) {
			System.out.println(item);
		}
	}
	
	public static int[] convertSortToIntArray(String[] str) {
		int[] num = new int[str.length];
		for (int i = 0 ; i < str.length ; i++) {
			num[i] = Integer.parseInt(str[i]);
		}
		return num;
	}
	
	public static void printIntArray(int[] num) {
		for (int n : num) {
			System.out.println(n);
		}
	}
/*
 * split(" ")
 * parseInt(stringArray[i])
 */
    // 문자열을 공백으로 분리하여 배열에 저장하고 정렬하는 함수
   

    // 문자열 배열을 정수 배열로 변환한 후 정렬하는 함수
    

    // 문자열 배열 출력 함수
    

    // 정수 배열 출력 함수
    

    public static void main(String[] args) {
        String input = "12 111 911 921 94 23 214 222";
        
        // 문자열 배열 정렬 및 출력
        String[] sortedStringArray = splitSortString(input);
        System.out.println("Sorted String Array:");
        printStringArray(sortedStringArray);
        
        // 문자열 배열을 정수 배열로 변환 및 정렬 후 출력
        int[] sortedIntArray = convertSortToIntArray(sortedStringArray);
        System.out.println("Sorted Integer Array:");
        printIntArray(sortedIntArray);
    }
}
