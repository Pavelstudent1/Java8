package minHash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShinglesSimple {
	
	private int[] hashes;
	
	public ShinglesSimple(String text, int sh_length) {
		
		hashes = new int[text.split(" ").length - sh_length + 1];
		int i = 0;
		for (String s : Utils.shinglesByWords(text, sh_length)) {
			hashes[i++] = s.hashCode();
		}
	}
	
	public Set<Integer> getHashesAsSet(){
		Set<Integer> set = new HashSet<>();
		for (int j = 0; j < hashes.length; j++) {
			if (!set.add(hashes[j])){
				System.out.println("error!");
			}
		}
		
		return set;
	}
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Set<String> stopWords = Utils.createStopWordsSet(System.getProperty("user.dir") + "\\files\\eng_stopwords.txt");
		
		String t1 = Utils.readToSingleString(System.getProperty("user.dir") + "\\files\\text1.txt", stopWords);
		String t2 = Utils.readToSingleString(System.getProperty("user.dir") + "\\files\\text2.txt", stopWords);
		String t3 = Utils.readToSingleString(System.getProperty("user.dir") + "\\files\\text3.txt", stopWords);
		
		Set<String> set1 = Utils.convertToSet(t1);
		Set<String> set2 = Utils.convertToSet(t2);
		Set<String> set3 = Utils.convertToSet(t3);
		
		Set<String> set4 = new HashSet<>();
		set4.addAll(Arrays.asList("beginning","nothing","fortunately","deep"));
		
		System.out.println("Similarity: " + MinHash2.JaccardSimilarity(set1, set2) + "\nSet1: " + set1.size() + "\nSet2: " + set2.size());
		
		
		ShinglesSimple shs1 = new ShinglesSimple(t1, 10);
		ShinglesSimple shs2 = new ShinglesSimple(t2, 10);
		Set<Integer> setS1 = shs1.getHashesAsSet();
		Set<Integer> setS2 = shs2.getHashesAsSet();
		System.out.println("Similarity: " + MinHash2.JaccardSimilarity(setS1, setS2) + "\nSet1: " + setS1.size() + "\nSet2: " + setS2.size());
		
	}
	/**
	 * http://www.codeisart.ru/blog/part-1-shingles-algorithm-for-web-documents/
	 * https://habrahabr.ru/post/52120/
	 * http://www.aot.ru/
	 * http://rcdl2007.pereslavl.ru/papers/paper_65_v1.pdf
	 * https://ru.wikipedia.org/wiki/%D0%92%D0%B5%D0%BA%D1%82%D0%BE%D1%80%D0%BD%D0%B0%D1%8F_%D0%BC%D0%BE%D0%B4%D0%B5%D0%BB%D1%8C
	 * https://github.com/rclayton/StringSimilarity
	 * https://habrahabr.ru/post/65944/
	 * https://blog.cluster-text.com/tag/minhash/
	 * http://infolab.stanford.edu/~ullman/mmds/ch3.pdf
	 * http://matthewcasperson.blogspot.ru/2013/11/minhash-for-dummies.html
	 */
}
