package minHash;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Utils {
	
	public static Set<String> createStopWordsSet(String pathTo){
		
		Scanner scanner = createScanner(pathTo);
		Set<String> sw = new HashSet<>();
		
		while(scanner.hasNext()){
			String s = scanner.next();
			sw.add(s);
		}
		
		scanner.close();
		return sw;
	}

	private static Scanner createScanner(String pathTo) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(pathTo));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return scanner;
	}
	
	public static String readToSingleString(String path, Set<String> stopwords){
		
		Scanner scanner = createScanner(path);
		StringBuilder sb = new StringBuilder();
		
		while(scanner.hasNext()){
			String s = scanner.next().toLowerCase();
			s = s.replaceAll("\\W*", "");
			if (stopwords.contains(s) || s.length() == 0) continue;
			sb.append(s + " ");
		}
		
		sb.deleteCharAt(sb.length() - 1);
		scanner.close();
		return sb.toString();
	}
	
	public static String cleanString(String s){
		return s = s.toLowerCase().replaceAll("[^a-z|\\s]", "");
	}
	
	public static Set<String> convertToSet(String text){
		Set<String> set = new HashSet<>();
		for(String s : text.split(" ")){
			set.add(s);
		}
		return set;
	}

	public static Iterable<String> shinglesByWords(final String s, final int sh_length_in_words){
		return new Iterable<String>() {
			@Override
			public Iterator<String> iterator() {
				
				return new Iterator<String>() {
					
					private final String[] splitted = s.split(" ");
					private int MAX_SHINGLES = splitted.length - sh_length_in_words + 1;
					private int sh_count = 0;
					@Override
					public boolean hasNext() {
						return sh_count < MAX_SHINGLES;
					}

					@Override
					public String next() {
						String sh = IntStream
										.range(sh_count, sh_count + sh_length_in_words)
										.mapToObj(i -> splitted[i])
										.reduce((t, u) -> t + " " + u)
										.get();
						++sh_count;
						return sh;
					}
				};
			}
		};
		
	}

	
	public static <T> double JaccardSimilarity(final Set<T> s1, final Set<T> s2){
		
		Set<T> intersection = new HashSet<>(s1);
		intersection.retainAll(s2);
		
		Set<T> union = new HashSet<>(s1);
		union.addAll(s2);
		
		return (double)intersection.size() / union.size();
	}
}
