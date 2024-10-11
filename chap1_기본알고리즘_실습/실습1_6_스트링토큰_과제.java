package chap1_기본알고리즘_실습;

import java.util.StringTokenizer;

public class 실습1_6_스트링토큰_과제 {
	
	public static String[] extractSortStrings(String str) {
		StringTokenizer st = new StringTokenizer(str);
		String[] array = new String[st.countTokens()];
		int i = 0;
		while (st.hasMoreTokens()) {
			array[i] = st.nextToken();
			i++;
		}
		return array;
	}
	
	public static void printStringArray(String[] str) {
		for (String item : str) {
			System.out.println(item);
		}
	}
	
	public static double[] convertSortToDouble(String[] str) {
		double[] db = new double[str.length];
		int i = 0;
		for (String item : str) {
			db[i] = Double.parseDouble(item);
			i++;
		}
		return db;		
	}
	
	public static void printDoubleArray(double[] db) {
		for (Double num : db) {
			System.out.println(num);
		}
	}
/*
 * StringTokenizer(input), countTokens(), hasMoreTokens(), nextToken()
 * parseDouble(stringArray[i])
 */
    // 문자열을 실수로 추출하여 배열에 저장하고 정렬하는 함수
    

    // 문자열 배열을 실수 배열로 변환한 후 정렬하는 함수
       
    // 문자열 배열을 실수 배열로 변환
        

    // 문자열 배열 출력 함수
    

    // 실수 배열 출력 함수
    

    public static void main(String[] args) {
        String msg = "3.24 3.34156 1141.56 214. 0.0314156 54.12f";
        
        // 실수를 문자열로 추출하고 정렬 후 출력
        String[] sortedStringArray = extractSortStrings(msg);
        System.out.println("정렬 스트링 배열:");
        printStringArray(sortedStringArray);
        
        // 문자열 배열을 실수 배열로 변환하고 정렬 후 출력
        double[] sortedDoubleArray = convertSortToDouble(sortedStringArray);
        System.out.println("정렬 실수 배열:");
        printDoubleArray(sortedDoubleArray);
    }
}
