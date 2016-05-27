package minHash;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class MinHash2 {
	
	public static <T> double JaccardSimilarity(final Set<T> s1, final Set<T> s2){
		
		Set<T> intersection = new HashSet<>(s1);
		intersection.retainAll(s2);
		
		Set<T> union = new HashSet<>(s1);
		union.addAll(s2);
		
		return (double)intersection.size() / union.size();
	}
	
	public static <T> double JaccardTanimotoSimilarity(final Set<T> s1, final Set<T> s2){
		
		Set<T> intersection = new HashSet<>(s1);
		s1.retainAll(s2);
		
		
		return (double)intersection.size() / (s1.size() + s2.size() - intersection.size());
	}
	
	
	public static int[] generateVectorOfRandomInt(int length){
		Random random = new Random();
		int[] vector = new int[length];
		
		for(int i = 0; i < length; i++){
			vector[i] = random.nextInt();
		}
		
		return vector;
	}
	
	public static String cleanString(String s){
		
		return s = s.toLowerCase().replaceAll("[^a-z|\\s]", "");
	}
	
	public static Iterable<String> shingles(final String s, final int sh_length){
		return new Iterable<String>() {
			@Override
			public Iterator<String> iterator() {
				
				return new Iterator<String>() {
					
					private int MAX_SHINGLES = s.length() - sh_length + 1;
					private int sh_count = 0;
					@Override
					public boolean hasNext() {
						return sh_count < MAX_SHINGLES;
					}

					@Override
					public String next() {
						String out = s.substring(sh_count, sh_count + sh_length);
						++sh_count;
						return out;
					}
				};
			}
		};
		
	}
	
	public static Iterable<String> shingles2(final String s, final int sh_length){
		return new Iterable<String>() {
			@Override
			public Iterator<String> iterator() {
				
				return new Iterator<String>() {
					
					private final String[] splitted = s.split(" ");
					private int MAX_SHINGLES = splitted.length - sh_length + 1;
					private int sh_count = 0;
					@Override
					public boolean hasNext() {
						return sh_count < MAX_SHINGLES;
					}

					@Override
					public String next() {
						String sh = IntStream
										.range(sh_count, sh_count + sh_length)
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
	
	
	
	public static void main(String[] args) {
		
		String[] docs = new String[]{
        		"The „central dogma‟ of molecular biology is that biological information flows from DNA to RNA to protein by well defined molecular processes or „algorithms‟, whereas proteins do not change the genetic code. With some notable exceptions, all living cells conform to this rule. DNA, the genetic material, also termed the “book of life” contains all necessary information for RNA (and consequently protein) production, and hence serves as the blueprint for building the entire cellular machinery. Therefore, the beginning of the twenty first century witnessed a remarkable scientific project towards deciphering the genetic constitution of organisms. The sequencing of the complete genome of an organism has been a landmark in the history of biomedical research, which was the result of concerted scientific and technological orchestration between various disciplines of biomedical, physical and material sciences.",
        		"\"Central dogma\" of molecular biology is that biological information flows from DNA to RNA protein of well defined molecular processes or \"algorithms\", while the proteins do not alter the genetic code. With a few exceptions, all living cells conform to this rule. DNA genetic material, also called the \"book of life\" contains all the necessary information to the RNA (and thus protein) production, and thus serves as a basis for constructing whole cellular machinery. Thus, the beginning of the twenty-first century have witnessed a remarkable scientific project in relation to the deciphering of the genetic constitution of an organism. Sequencing of the complete genome of an organism has become an important event in the history of biomedical research that is the result of concerted scientific and technological orchestration between different disciplines of medical and biological, physical and material sciences."
                };
		
		String s1 = cleanString(docs[0]);
		String s2 = cleanString(docs[1]);
		
		int[] hashes1 = calcHashes(s1);
		int[] hashes2 = calcHashes(s2);
		
		Set<Integer> set1 = createSet(hashes1);
		Set<Integer> set2 = createSet(hashes2);
		
		double jd = JaccardSimilarity(set1, set2);
		System.out.println(jd);
	}

	public static int[] calcHashes(String s1) {
		
		int[] hashes = new int[s1.split(" ").length - 5 + 1];
		int i = 0;
		for (String s : shingles2(s1, 5)) {
			hashes[i] = s.hashCode();
			++i;
		}
		
		return hashes;
	}

	public static Set<Integer> createSet(int[] minHashes1) {

		Set<Integer> set = new HashSet<>();
		for (Integer i : minHashes1) {
			if (!set.add(i)){
				System.out.println("error!");
			}
		}
		
		return set;
	}
	
}
