package Chap3_검색;

//중복이 없는 리스트를 merge하는 버젼

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class train_실습3_9_2스트링중복없는리스트합병 {
//string 정렬, binary search 구현
//1단계: string, 2단계: string 객체,  Person 객체들의 list\
//file1: 서울,북경,상해,서울,도쿄, 뉴욕,부산
//file2: 런던, 로마,방콕, 도쿄,서울,부산
//file > string split() > 배열 > ArrayList > sort > iterator 사용하여 merge > 중복 제거 > string 배열 > file에 저장

	/*
	 * static int binSearch(String[] s, int n, String key) { //자료구조 책 페이지 115 코드
	 * 사용한다. }
	 */
	static ArrayList<String> removeDuplicate(ArrayList<String> al) {
		ArrayList<String> list1 = al;
		for (int i = 1; i < list1.size(); i++) {
			if (list1.get(i).compareTo(list1.get(i - 1)) == 0) {
				list1.remove(i);
				i--;
			}
		}
		return list1;
	}

	static void showData(String message, String[] arr) {
		System.out.println(message);
		for (String item : arr) {
			System.out.print(item + " ");
		}
		System.out.println();

	}

	static void trimSpace(String[] arr) {
		/*
		 * string.trim() 사용으로 좌우 빈공백 제거
		 */

	}

	static void makeList(String[] sarray1, List<String> list1) {
		for (String item : sarray1) {
			list1.add(item);
		}
	}

	static void showList(String message, List<String> arr) {
		System.out.println(message);
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i) + " ");
		}
		System.out.println();
	}

	static List<String> mergeList(List<String> list1, List<String> list2) {

		ArrayList<String> list3 = new ArrayList<>();
		// ------- ArrayList의 get()을 사용한 merge
		do {
			if(list1.get(0).compareTo(list2.get(0)) == 0) {
				list3.add(list1.get(0));
				list1.remove(0);
				list2.remove(0);
			} else if (list1.get(0).compareTo(list2.get(0)) < 0) {
				list3.add(list1.get(0));
				list1.remove(0);
			} else {
				list3.add(list2.get(0));
				list2.remove(0);
			}
		} while(!list1.isEmpty() && !list2.isEmpty());
		
		if(list1.isEmpty()) {
			while(!list2.isEmpty()) {
				list3.add(list2.get(0));
				list2.remove(0);
			}
		} else if (list2.isEmpty()) {
			while(!list1.isEmpty()) {
				list3.add(list1.get(0));
				list1.remove(0);
			}
		}
		
		return list3;
					
	}

	public static void main(String[] args) {
		try {

			Path input1 = Paths.get("src/files/a1.txt");
			byte[] bytes1 = Files.readAllBytes(input1);
			// readAllBytes: 파일의 모든 바이트를 읽어오는 메서드입니다.
			// 이 메서드는 파일을 열고 파일의 크기만큼 바이트를 읽어서 바이트 배열로 반환합니다.
			System.out.println("bytes[]의 길이 = " + bytes1.length);
			Path input2 = Paths.get("src/files/a2.txt");
			byte[] bytes2 = Files.readAllBytes(input2);

			String s1 = new String(bytes1);
			String s2 = new String(bytes2);
			System.out.println("입력 스트링: s1 = " + s1);
			System.out.println("입력 스트링: s2 = " + s2);
			String[] sarray1 = s1.split("[,\\s\\r\\n]+");// [,\\s]+\r\n은 쉼표나 공백이 하나 이상 나오고 이어서 캐리지 리턴과 개행 문자가 있는 패턴
			String[] sarray2 = s2.split("[,\\s\\r\\n]+");// file에서 enter키는 \r\n으로 해야 분리됨
			showData("스트링 배열 sarray1", sarray1);
			showData("스트링 배열 sarray2", sarray2);

//			trimSpace(sarray1);
//			trimSpace(sarray2);

			showData("trimSpace() 실행후 :스트링 배열 sarray1", sarray1);
			showData("trimSpace() 실행후 :스트링 배열 sarray2", sarray2);
			System.out.println("+++++++\n");
			// file1에서 read하여 list1.add()한다.
			// 배열을 list로 만드는 방법
			// 방법1:
			ArrayList<String> list1 = new ArrayList<>();
			makeList(sarray1, list1);
			showList("리스트1: ", list1);
			// 방법2
			ArrayList<String> list2 = new ArrayList<>(Arrays.asList(sarray2));
			showList("리스트2: ", list2);

			System.out.println("+++++++ collection.sort()::");
			Collections.sort(list1);
			showList("정렬후 리스트1: ", list1);

			// Arrays.sort(list2, null);//에러 발생 확인하고 이유는?
			Collections.sort(list2);
			showList("정렬후 리스트2: ", list2);

			// 정렬된 list에서 중복 제거 코드
			list1 = removeDuplicate(list1);
			list2 = removeDuplicate(list2);
			showList("중복 제거후 리스트1: ", list1);
			showList("중복 제거후 리스트2: ", list2);

			List<String> list3 = new ArrayList<>();

			// 방법3:
			list3 = mergeList(list1, list2);
			showList("merge후 합병리스트: ", list3);

			// ArrayList를 배열로 전환
			String[] st = list3.toArray(new String[list3.size()]);
			// binary search 구현
			// binSearch(st, st.length, "key");
			// 정렬된 list3을 file에 출력하는 코드 완성
			System.out.println("\n" + "file에 출력:");
			int bufferSize = 10240;

			ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
			writeBuffer(list3, buffer);

			FileOutputStream file = new FileOutputStream("src/files/c.txt");// 스트림을 통해 파일에 데이터를 쓴다
			FileChannel channel = file.getChannel();// FileOutputStream 객체에서 채널을 가져오는 메서드
			channel.write(buffer);// write() 메서드는 buffer를 매개변수로 받아, 버퍼에 저장된 데이터를 파일에 쓴다
			file.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void writeBuffer(List<String> list3, ByteBuffer buffer) {
		String b = " ";
		for (String sx : list3) {
			System.out.println(" " + sx);
			buffer.put(sx.getBytes());
			buffer.put(b.getBytes());
		}
		buffer.flip();
	}
}
