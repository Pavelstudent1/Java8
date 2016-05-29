package minHash;

import java.util.HashSet;
import java.util.Set;

public class TestClass {
	
	public static void main(String[] args) {
		
		String[] docs = new String[]{
        		"The „central dogma‟ of molecular biology is that biological information flows from DNA to RNA to protein by well defined molecular processes or „algorithms‟, whereas proteins do not change the genetic code. With some notable exceptions, all living cells conform to this rule. DNA, the genetic material, also termed the “book of life” contains all necessary information for RNA (and consequently protein) production, and hence serves as the blueprint for building the entire cellular machinery. Therefore, the beginning of the twenty first century witnessed a remarkable scientific project towards deciphering the genetic constitution of organisms. The sequencing of the complete genome of an organism has been a landmark in the history of biomedical research, which was the result of concerted scientific and technological orchestration between various disciplines of biomedical, physical and material sciences.",
        		"\"Central dogma\" of molecular biology is that biological information flows from DNA to RNA protein of well defined molecular processes or \"algorithms\", while the proteins do not alter the genetic code. With a few exceptions, all living cells conform to this rule. DNA genetic material, also called the \"book of life\" contains all the necessary information to the RNA (and thus protein) production, and thus serves as a basis for constructing whole cellular machinery. Thus, the beginning of the twenty-first century have witnessed a remarkable scientific project in relation to the deciphering of the genetic constitution of an organism. Sequencing of the complete genome of an organism has become an important event in the history of biomedical research that is the result of concerted scientific and technological orchestration between different disciplines of medical and biological, physical and material sciences.",
                "One consideration for implementations of the Java Virtual Machine is that every field and array element is considered distinct; updates to one field or element must not interact with reads or updates of any other field or element. In particular, two threads that update adjacent elements of a byte array separately must not interfere or interact and do not need synchronization to ensure sequential consistency. Some processors do not provide the ability to write to a single byte. It would be illegal to implement byte array updates on such a processor by simply reading an entire word, updating the appropriate byte, and then writing the entire word back to memory. This problem is sometimes known as word tearing, and on processors that cannot easily update a single byte in isolation some other approach will be required."};
		
		String[] data = {"I love books and films", "I hate books and films"};
		Set<String> set1 = createSet(MinHash2.cleanString(docs[0]));
		Set<String> set2 = createSet(MinHash2.cleanString(docs[1]));
		
		MinHash3 minHash = new MinHash3(0.01);
		int[] sig1 = minHash.signature(set1);
		int[] sig2 = minHash.signature(set2);
		
		System.out.println(MinHash2.JaccardSimilarity(
				MinHash2.createSet(sig1), MinHash2.createSet(sig2)));
		
		System.out.println(MinHash2.JaccardTanimotoSimilarity(
				MinHash2.createSet(sig1), MinHash2.createSet(sig2)));
		
		
	}
	
	public static Set<String> createSet(String s){
		Set<String> set = new HashSet<>();
		
		for(String sh : MinHash2.shingles(s, 3)){
			set.add(sh);
		}
		
		return set;
	}
}
