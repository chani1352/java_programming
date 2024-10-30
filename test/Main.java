package test;

import java.io.*;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int bag = Integer.parseInt(st.nextToken());
		int[] result = new int[bag];
		int count = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < count ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for(int j = a-1 ; j < b ; j++) {
				result[j] = c;
			}	
		}
		for(int i = 0 ; i < bag ; i++) {
			System.out.print(result[i] + " ");
		}
	
	}
}