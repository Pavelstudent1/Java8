package minHash;

import java.util.Random;
import java.util.Set;

public class MinHash3 {
	
	private Random random = new Random();
	private int err;
	private int[] xores;
	private int count;

	public MinHash3(double err) {
//		this.err = (int) (Math.round(1.0 / err * err));
		this.err = 20;
		this.xores = new int[this.err];
		for(int i = 0; i < xores.length; i++){
			xores[i] = random.nextInt();
		}
		this.count = xores.length;
	}
	
	public int findMinHash(Set<String> set, int xorAt){
		
		int min = Integer.MAX_VALUE;
		for (String s : set) {
			int hash = s.hashCode() ^ xorAt;
			if (hash < min){
				min = hash;
			}
		}
		
		return min;
	}
	
	public int[] signature(Set<String> set){
		int[] sig = new int[this.count];
		
		for (int i = 0; i < sig.length; i++) {
			sig[i] = findMinHash(set, xores[i]);
		}
		
		return sig;
	}
	
}
