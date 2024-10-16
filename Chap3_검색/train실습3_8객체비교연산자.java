package Chap3_검색;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 3장 4번 실습과제 - 객체 배열의 정렬과 이진검색 - Comparator 구현
 * 3장 실습 3-8를 수정하여 객체 배열의 정렬 구현
 */

class PhyscData3 {
	String name;
	int height;
	double vision;
	
	public PhyscData3(String name,int height,double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	
	

	public String getName() {
		return name;
	}



	public int getHeight() {
		return height;
	}


	public double getVision() {
		return vision;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name : " + this.name + "\theight : " + this.height + "\tvision : " + this.vision;
	}
	
	

}
//class NameOrder implements Comparator<PhyscData3>{
//
//}

class HeightOrder implements Comparator<PhyscData3>{

	@Override
	public int compare(PhyscData3 o1, PhyscData3 o2) {
		// TODO Auto-generated method stub
		if (o1.height == o2.height) return 0;
		else return (o1.height - o2.height) > 0 ? 1 : -1;
	}
	
	

}
class VisionOrder implements Comparator<PhyscData3>{

	@Override
	public int compare(PhyscData3 o1, PhyscData3 o2) {
		// TODO Auto-generated method stub
		if (o1.vision == o2.vision) return 0;
		else return (o1.vision - o2.vision) > 0 ? 1 : -1;
	}

}
public class train실습3_8객체비교연산자 {	
	static final Comparator<PhyscData3> HEIGHT_ORDER = new HeightOrder();
	
	static void showData(String msg,PhyscData3[] arr) {
		System.out.println(msg);
		for(PhyscData3 item : arr) {
			System.out.println(item);
		}
	}

	public static void main(String[] args) {
		PhyscData3[] data = {
				new PhyscData3("홍길동", 162, 0.3),
				new PhyscData3("나가자", 164, 1.3),
				new PhyscData3("다정해", 152, 0.7),
				new PhyscData3("소주다", 172, 0.4),
				new PhyscData3("사이다", 182, 0.6),
				new PhyscData3("신정신", 166, 1.2),
				new PhyscData3("이기자", 167, 1.5),
		};
		showData("정렬전 객체 배열", data);
		Arrays.sort(data, HEIGHT_ORDER);	
		showData("height로 정렬후 객체 배열", data);
		
		PhyscData3 key = new PhyscData3("길동", 167, 0.2);
		
		int idx = Arrays.binarySearch(data, key, HEIGHT_ORDER);
		System.out.println("\nArrays.binarySearch(data, key, HEIGHT_ORDER): result = " + idx);
		Arrays.sort(data, new VisionOrder());
		showData("vision로 정렬후 객체 배열", data);
		
		Arrays.sort(data, new Comparator<PhyscData3>() {
			@Override
			public int compare(PhyscData3 a1, PhyscData3 a2) {
				return a1.getName().compareTo(a2.getName());
			}
		});
		showData("name로 정렬후 객체 배열", data);
	}

}
