package minHash;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class MinHash {
	
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
	
	public static int[] calcMinHash(String text, int sh_length, int sh_amount, int[] hashes){
		Random random = new Random();
		String[] words = text.split(" ");
		int amountOfShingles = words.length - sh_length + 1;
		
		int[] items = new int[sh_amount];
		for(int i = 0; i < items.length; i++){
			items[i] = random.nextInt(amountOfShingles);
		}
		
		
		String[] shingles = new String[sh_amount];
		for (int i = 0; i < shingles.length; i++) {
			String s = words[items[i]];
			for (int j = 1; j < sh_length; j++) {
				s += words[items[i] + j];
			}
			shingles[i] = s;
		}
		
		
		int[] minHash = new int[sh_amount];
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < hashes.length; i++){
			
			for(int j = 0; j < shingles.length; j++){
				int hash = shingles[j].hashCode() ^ hashes[i];
				if (hash < min){
					min = hash;
				}
				
			}
			
			minHash[i] = min;
			min = Integer.MAX_VALUE;
		}
		
		return minHash;
	}
	
	public static int[] calcMinHash2(String text, int sh_length, int sh_amount, int[] hashes){
		Random random = new Random();
		String s = text.toLowerCase().replaceAll("[^a-z|\\s]", "");
		String[] words = s.split(" ");
		
		int[] items = new int[sh_amount];
		for(int i = 0; i < items.length; i++){
			items[i] = random.nextInt(sh_amount);
		}
		
		
		String[] shingles = new String[sh_amount];
		for (int i = 0; i < shingles.length; i++) {
			shingles[i] = words[items[i]];
		}
		
		
		int[] minHash = new int[sh_amount];
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < hashes.length; i++){
			
			for(int j = 0; j < shingles.length; j++){
				int hash = shingles[j].hashCode() ^ hashes[i];
				if (hash < min){
					min = hash;
				}
				
			}
			minHash[i] = min;
			min = Integer.MAX_VALUE;
		}
		
		return minHash;
	}
	
	
	
	public static void main(String[] args) {
		
		String[] docs = new String[]{
        		"The „central dogma‟ of molecular biology is that biological information flows from DNA to RNA to protein by well defined molecular processes or „algorithms‟, whereas proteins do not change the genetic code. With some notable exceptions, all living cells conform to this rule. DNA, the genetic material, also termed the “book of life” contains all necessary information for RNA (and consequently protein) production, and hence serves as the blueprint for building the entire cellular machinery. Therefore, the beginning of the twenty first century witnessed a remarkable scientific project towards deciphering the genetic constitution of organisms. The sequencing of the complete genome of an organism has been a landmark in the history of biomedical research, which was the result of concerted scientific and technological orchestration between various disciplines of biomedical, physical and material sciences.",
        		"\"Central dogma\" of molecular biology is that biological information flows from DNA to RNA protein of well defined molecular processes or \"algorithms\", while the proteins do not alter the genetic code. With a few exceptions, all living cells conform to this rule. DNA genetic material, also called the \"book of life\" contains all the necessary information to the RNA (and thus protein) production, and thus serves as a basis for constructing whole cellular machinery. Thus, the beginning of the twenty-first century have witnessed a remarkable scientific project in relation to the deciphering of the genetic constitution of an organism. Sequencing of the complete genome of an organism has become an important event in the history of biomedical research that is the result of concerted scientific and technological orchestration between different disciplines of medical and biological, physical and material sciences."
                };
		
		int h_count = 100;
		int sh_length = 9;
		int[] vector = generateVectorOfRandomInt(h_count);
		int[] minHashes1 = calcMinHash2(docs[0], sh_length, h_count, vector);
		int[] minHashes2 = calcMinHash2(docs[1], sh_length, h_count, vector);
		
		Set<Integer> s1 = createSet(minHashes1);
		Set<Integer> s2 = createSet(minHashes2);
		
		double sim = JaccardSimilarity(s1, s2);
		System.out.println("Jaccard=" + sim);	
	}

	private static Set<Integer> createSet(int[] minHashes1) {

		Set<Integer> set = new HashSet<>();
		for (Integer i : minHashes1) {
			if (!set.add(i)){
				System.out.println("error!");
			}
		}
		
		return set;
	}
	
}
