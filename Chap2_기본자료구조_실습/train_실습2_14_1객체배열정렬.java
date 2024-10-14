package Chap2_기본자료구조_실습;
/*
 * 2장 제출 과제 
 * Comparable 인터페이스의 구현 
 * 5번 실습 - 2장 실습 2-10를 수정하여 객체 배열의 정렬 구현
 */
import java.util.Arrays;

class PhyscData implements Comparable<PhyscData>{
	String name;
	int height;
	double vision;
	
	public PhyscData (String name, int height,double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	
	@Override
	public String toString() {//Object 클래스 상속
		return "name : " + this.name + "\theight : " + this.height + "\tvision : " + this.vision ;
	}
	@Override
	public int compareTo(PhyscData p) {

	}
//	public boolean equals(Object ob) {//Object 클래스 상속
//		 PhyscData p = (PhyscData) ob;
//
//	}
}
public class train_실습2_14_1객체배열정렬 {
	static void swap(PhyscData[] data , int i, int j) {
		PhyscData dat;
		dat = data[i];
		data[i] = data[j];
		data[j] = dat;
	}
	static void sortData(PhyscData[] data) {//객체 배열을 이름 순서로 정렬, 이름이 같으면 키 값을 정렬, 키 값이 같으면 시력으로 
		//compareTo()를 사용하여 구현
		for(int i = 0 ; i < data.length-1 ; i++) {
			for(int j = 0 ; j < data.length-1 ; j++) {
				if(data[j].compareTo(data[j+1]) > 0) swap(data,j,j+1);
			}
		}
	}
//	binarySearch() {
//		//if (data[i].equals(key)) ***으로 구현
//		
//	} //equals()를 사용하여 구현
	public static void main(String[] args) {
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("이기자", 164, 1.3),
				new PhyscData("나가자", 162, 0.7),
				new PhyscData("사이다", 172, 0.3),
				new PhyscData("신정신", 182, 0.6),
				new PhyscData("원더풀", 167, 0.2),
				new PhyscData("다정해", 169, 0.5),
		};
		showData("정렬전",data);
//		sortData(data);
//		showData("정렬후", data);
//		int resultIndex = binarySearch(data, "사이다")
//		PhyscData[] newData= insertObject(data, new PhyscData("소주다", 179, 1.5));//배열의 사이즈를 1개 증가시킨후 insert되는 객체 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 객체 배열을 리턴
//		showData("삽입후", newData);
		
	}
	static void showData(String msg, PhyscData[] data) {
		System.out.println(msg);
		for(PhyscData item : data) {
			System.out.println(item);
		}
	}
//	insertObject(){//배열의 사이즈를 1개 증가시킨후 insert되는 스트링 보다 큰 값들은 우측으로 이동, 사이즈가 증가된 스트링 배열을 리턴
//		
//	}

}
