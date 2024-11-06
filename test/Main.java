package test;

public class Main{
	public static void main(String[] args) {
		String s = "한국,일본,중국,미국";
		String[] list = s.split(",");
		for(String item : list) {
			System.out.println(item);
		}
		
		String s1 = s.substring(0,2);
		System.out.println("S1" + s1);
		
		String.valueOf(false)
		
	}
}