package test;

public class test {
	public static void main(String[] args) {
		
		String s = "hello";
		int hashCode = System.identityHashCode(s);
		System.out.println(hashCode);
		
		s = s + "hello";
		hashCode = System.identityHashCode(s);
		System.out.println(hashCode);
		System.out.println(s);
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("hello");
		hashCode = System.identityHashCode(sb);
		System.out.println(hashCode);
		sb.append("hello");
		hashCode = System.identityHashCode(sb);
		System.out.println(hashCode);
		System.out.println(sb);
	}

}
