package Chap3_검색;

/*
 * 3장 3번 실습과제 - 객체 배열의 정렬과 이진검색 - Comparable 구현
 * 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
 * 함수(메소드) 전체를 작성하는 훈련 
 */
import java.util.Arrays;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData2 implements Comparable<PhyscData2>{
	String name;
	int height;
	double vision;
	
	public PhyscData2(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	@Override
	public String toString() {//[홍길동,162,0.3] 형태로 리턴한다 
		return "[" + name + "," + height + "," + vision + "]";
	}
	
	@Override
	public int compareTo(PhyscData2 p) {
		if (name.compareTo(p.name) == 0) {
			if (height == p.height) {
				if(vision == p.vision) return 0;
				else return vision > p.vision ? 1 : -1;
			} else
				return height > p.height ? 1 : -1;
		} else
			return name.compareTo(p.name);
		// name 비교 버젼
		// height 비교 버젼
	}

}
public class train_실습3_6_1객체배열이진탐색 {
	
	static void showData(String msg, PhyscData2[] arr) {
		System.out.println(msg);
		for (PhyscData2 item : arr) {
			System.out.println(item);
		}
	}

	static void sortData(PhyscData2[] arr) {
		int len = arr.length;
		for (int i = 1; i < len; i++) {
			for (int j =(i - 1); j >= 0; j--) {
				if (arr[j+1].compareTo(arr[j]) < 0) {
					swap(arr,j+1,j);
				} else break;
			}
		}
	}
	
	static void swap(PhyscData2[] arr, int i, int j) {
		PhyscData2 data = arr[i];
		arr[i] = arr[j];
		arr[j] = data;
	}
	
	static void reverse(PhyscData2[] data) {
		int len = data.length;
		for (int i = 0 ; i < len/2 ; i++) {
			swap(data,i,len-i-1);
		}
	}
	
	static int linearSearch(PhyscData2[] arr, PhyscData2 data) {
		int i = 0;
		for(PhyscData2 item : arr) {
			if (item.compareTo(data) == 0) return i;
			i++;
		}
		return -1;
	}
	
	static int binarySearch(PhyscData2[] arr, PhyscData2 data) {
		int st = 0;
		int end = arr.length-1;
		int cent;
		
		do {
			cent = (end+st)/2;
			if(arr[cent].compareTo(data) == 0) return cent;
			else if(arr[cent].compareTo(data) > 0) end = cent-1;
			else st = cent + 1 ;
		} while (st <= end);	
		return -1;
	}
	
	public static void main(String[] args) {
		PhyscData2[] data = {
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("나동", 164, 1.3),
				new PhyscData2("최길", 152, 0.7),
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("박동", 182, 0.6),
				new PhyscData2("박동", 167, 0.2),
				new PhyscData2("길동", 167, 0.5),
		};
		showData("정렬전", data);
		sortData(data);//6장 06-4 단순 삽입 정렬 InsertionSort() 함수로 구현
		showData("정렬후", data);
		reverse(data);
		showData("역순 재배치후", data);
		Arrays.sort(data);//사용된다 그 이유는? 이해가 되어야 한다 - compareTo() 구현을 변경하여 실행결과를 확인
		showData("Arrays.sort() 정렬후", data);
		
		PhyscData2 key = new PhyscData2("길동", 167, 0.5);
		int resultIndex = linearSearch(data, key);//compareTo()를 사용하여 구현
		System.out.println("\nlinearSearch(<길동,167,0.5>): result index = " + resultIndex);
		
		key = new PhyscData2("박동", 167, 0.6);
		/*
		 * 교재 109~113
		 */
		resultIndex = binarySearch(data, key);//compareTo()를 사용하여 구현
		System.out.println("\nbinarySearch(<박동,167,0.6>): result index = " + resultIndex);
		key = new PhyscData2("나동", 164, 0.6);
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		resultIndex = Arrays.binarySearch(data, key);//compareTo()를 사용되는지를 확인-이해할 수 있어야 한다 
		System.out.println("\nArrays.binarySearch(<나동,164,0.6>): result index = " + resultIndex);
	}
	
	

}
