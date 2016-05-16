package lesson160329;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Example01 {
	
	public static void main(String[] args) {
		
		List<String> strList = Arrays.asList("a", "b", "A", "B");
		strList.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
		strList.sort(String::compareToIgnoreCase);
		System.out.println(strList);

		
		Map<String, String> map = new TreeMap<String, String>() {{	
			//Initialization block
				put("alpha", "X");
				put("brava", "Y");
				put("charlie", "Z");
		}};
		System.out.println(map);
		
//		String str = "alpha-brava-charlie";
		
//		map.replaceAll(str::replace);
//		//Последовательность:
//		//1. replaceAll берёт итеративно все entry (key and value) и передаёт их(!) в функцию в аргументе
//		//2. Функция в аргументе берёт эти два значения и делает replace, т.е:
//		//"alpha-brava-charlie".replace("alpha", "X") и возвращает alpha=X-brava-charlie, присваивая его ключу alpha
//		//"alpha-brava-charlie".replace и т.д. 
		
//		System.out.println(map);
		
		map.replaceAll(String::concat);
		System.out.println(map);
		
		
		
		
	}
}
