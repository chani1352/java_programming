package test;

import java.util.Arrays;

public class Main{
	public static void main(String[] args) {
		Integer[] arr = {1,3,6,4,2};
		Arrays.sort(arr);
		
		Arrays.sort(arr,(o1,o2) -> Integer.compare(o2,o1));
		System.out.println(Arrays.toString(arr));
		
		
		int[] arr1 = arr;
	}
}