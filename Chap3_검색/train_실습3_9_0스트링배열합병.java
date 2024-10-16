package Chap3_검색;

/*
 * 3장 과제1: 스트링 배열 합병 정렬
 */
import java.util.Arrays;
import java.util.List;

public class train_실습3_9_0스트링배열합병 {
	
	static void showList(String msg,String[] arr) {
		System.out.println(msg);
		for(String item : arr) {
			System.out.println(item);
		}
	}
	
	static String[] mergeList(String[] arr1, String[] arr2) {
		String[] s3 = new String[arr1.length + arr2.length];
		int len1 = 0;
		int len2 = 0;
		for(int i = 0 ; i < s3.length ; i++) {
			if(arr1[len1].compareTo(arr2[len2]) == 0 ) {
				s3[i] = arr1[len1];
				len1 += 1;
				len2 += 1;
			}
			else if (arr1[len1].compareTo(arr2[len2]) < 0 ) {
				s3[i] = arr1[len1];
				len1 += 1;
			}
			else s3[i] = arr2[len2];
			len2 += 1;
		}
		
		return s3;
		
	}
	
//	강감찬
//	계백
//	김유신
//	을지문덕
//	최치원
//	홍길동
//	
//	독도
//	동백섬
//	영도
//	오륙도
//	울릉도
//	한산도
	
	public static void main(String[] args) {
		String[] s1 = { "홍길동", "강감찬", "을지문덕", "계백", "김유신", "최치원" };
		String[] s2 = { "독도", "울릉도", "한산도", "영도", "오륙도", "동백섬" };
		Arrays.sort(s1);
		Arrays.sort(s2);

		showList("s1배열 = ", s1);
		showList("s2배열 = ", s2);

		String[] s3 = mergeList(s1, s2);// 정렬된 s1[], s2[]을 합병하여 다시 정렬된 결과를 만드는 함수 구현
		showList("스트링 배열 s3 = s1 + s2:: ", s3);
	}
}
