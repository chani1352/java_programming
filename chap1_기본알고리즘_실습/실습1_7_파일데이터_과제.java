package chap1_기본알고리즘_실습;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class 실습1_7_파일데이터_과제 {
/*
 * trim(),split(" ")
 */
    // 파일을 읽어 각 라인을 공백으로 분리하여 정렬하는 함수
    public static String[] readSortFromFile(String filename) {
    	// 저장할 데이터
        String data = "12 1 131 2 23";
        String data2 = " 312 32 8 22 7";
        // 파일에 데이터 쓰기
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
        	writer.write(data);
        	writer.write(data2);
        	
            // 데이터를 파일에 씀
            
        } catch (IOException e) {
            System.out.println("파일 쓰기 중 오류 발생: " + e.getMessage());
        }
        
        StringBuilder sb = new StringBuilder();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        	
            // 라인을 읽어서 StringBuilder에 추가
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 공백으로 구분된 서브스트링을 배열로 변환하고 정렬
     
        // 정렬된 배열 반환
    }

    // 문자열 배열을 정수 배열로 변환하고 정렬하는 함수
    

    // 문자열 배열 출력 함수
    

    // 정수 배열 출력 함수
  

    public static void main(String[] args) {
        String filename = "data.txt";  // 파일 이름 설정 (실제 파일 경로로 변경)

        // 파일에서 읽어온 문자열 배열을 정렬 후 출력
        String[] sortedStringArray = readSortFromFile(filename);
        System.out.println("Sorted String Array from File:");
        printStringArray(sortedStringArray);
        
        // 문자열 배열을 정수 배열로 변환하고 정렬 후 출력
        int[] sortedIntArray = convertSortToInt(sortedStringArray);
        System.out.println("Sorted Integer Array:");
        printIntArray(sortedIntArray);
    }
}
