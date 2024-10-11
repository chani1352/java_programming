package chap1_기본알고리즘_실습;

import java.util.Arrays;

public class 실습1_4_문자데이터변환_과제 {
	
	public static String[] convertValuesToString(boolean a,char b,double c,int d,float e) {
		String[] array = {String.valueOf(a),String.valueOf(b),String.valueOf(c),String.valueOf(d),String.valueOf(e)};
		return array;
	}
	
	public static void showAllString(String[] str) {
		for(String item : str) {
			System.out.println(item);
		}
	}
	
	public static String[] sortStringArray(String[] str) {
		Arrays.sort(str);
		return str;
	}
/*
 * valueOf(boolVal)
 * Arrays.sort(array)
 */
    // 값을 문자열로 변환하여 배열에 저장하는 함수
    

    // 배열을 정렬하는 함수
    

    // 배열을 출력하는 함수
    
    public static void main(String[] args) {
        // 정수, float, double, boolean 값을 문자열로 변환하여 배열에 저장
        String[] stringArray = convertValuesToString(true, 'A', 3.14, 123, 45.67f);
        
        // 정렬 전 배열 출력
        System.out.println("정렬전:");
        showAllString(stringArray);
        
        // 배열 정렬
        sortStringArray(stringArray);
        
        // 정렬 후 배열 출력
        System.out.println("\n정렬후:");
        showAllString(stringArray);
    }
}

