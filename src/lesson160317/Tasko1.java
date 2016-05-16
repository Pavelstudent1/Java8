package lesson160317;

import java.util.Arrays;
import java.util.Comparator;

public class Tasko1 {
	
	public static void main(String[] args) {
		
		String[] a = {"one", "two", "three", "four"};
		
//		Arrays.sort(a, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return o1.length() - o2.length();
//			}
//		});
		
//		Arrays.sort(a, (s1, s2) -> s1.length() - s2.length());
//		System.out.println(Arrays.toString(a));
		
		//Mine
//		1. Sorting by length, descending
//		Arrays.sort(a, (s1, s2) -> s2.length() - s1.length());
//		System.out.println(Arrays.toString(a));
		
//		2.Sort by 2nd letter
//		Arrays.sort(a, (s1, s2) -> s1.charAt(1) - s2.charAt(1));
//		System.out.println(Arrays.toString(a));
		
//		3. Sort by 2nd letter only words started from "t"
//		Arrays.sort(a, (s1, s2) -> s1.startsWith("t") && s2.startsWith("t") ? s1.charAt(1) - s2.charAt(1) : 0);
//		Arrays.sort(a, (s1, s2) -> s1.charAt(0) - s2.charAt(0) == 0 ? s1.charAt(1) - s2.charAt(1) : 0);
//		System.out.println(Arrays.toString(a));
		
		
		//
		Arrays.sort(a, (s1, s2) -> {
			return s1.length() - s2.length();
		});
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("hello");
			}
		}).start();
		
		new Thread(() -> System.out.println("hello")).start();
		
		
		
		
		
		
	}
	
}
