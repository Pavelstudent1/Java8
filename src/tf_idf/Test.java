package tf_idf;

public class Test {
	
	public static void main(String[] args) {
        String[] docs = new String[]{
        		"The „central dogma‟ of molecular biology is that biological information flows from DNA to RNA to protein by well defined molecular processes or „algorithms‟, whereas proteins do not change the genetic code. With some notable exceptions, all living cells conform to this rule. DNA, the genetic material, also termed the “book of life” contains all necessary information for RNA (and consequently protein) production, and hence serves as the blueprint for building the entire cellular machinery. Therefore, the beginning of the twenty first century witnessed a remarkable scientific project towards deciphering the genetic constitution of organisms. The sequencing of the complete genome of an organism has been a landmark in the history of biomedical research, which was the result of concerted scientific and technological orchestration between various disciplines of biomedical, physical and material sciences.",
        		"\"Central dogma\" of molecular biology is that biological information flows from DNA to RNA protein of well defined molecular processes or \"algorithms\", while the proteins do not alter the genetic code. With a few exceptions, all living cells conform to this rule. DNA genetic material, also called the \"book of life\" contains all the necessary information to the RNA (and thus protein) production, and thus serves as a basis for constructing whole cellular machinery. Thus, the beginning of the twenty-first century have witnessed a remarkable scientific project in relation to the deciphering of the genetic constitution of an organism. Sequencing of the complete genome of an organism has become an important event in the history of biomedical research that is the result of concerted scientific and technological orchestration between different disciplines of medical and biological, physical and material sciences."
                };
        TF_IDF tf_idf = new TF_IDF(docs);
        for (String s : tf_idf.getWordVector()) {
            System.out.print(s + "\t");
        }
        System.out.println("");
        for (double[] docV : tf_idf.getTF_IDFMatrix()) {
            for (double v : docV) {
                System.out.print(v + "\t");
            }
            System.out.println("");
        }
        
        System.out.println("\n\n");
        String[] words = tf_idf.getWordVector();
        double[][] docV = tf_idf.getTF_IDFMatrix();
        for(int i = 0; i < words.length; i++){
        	System.out.println(String.format("%-15s\t%f\t%f", words[i], docV[0][i], docV[1][i]));
        }
        
        double edist = calcEuclidDistance(docV[0], docV[1]);
        System.out.println("\nEuclidian distance is " + edist);
        
        double mdist = calcManhattanDistance(docV[0], docV[1]);
        System.out.println("Manhattan distance is " + mdist);
        
        double chdist = calcChebishevDistance(docV[0], docV[1]);
        System.out.println("Chebishev distance is " + chdist);
    }

	private static double calcChebishevDistance(double[] ds1, double[] ds2) {

		double diff = -1;
		
		for(int i = 0; i < ds1.length; i++){
			double m = Math.abs(ds1[i] - ds2[i]);
			if (m > diff){
				diff = m;
			};
		}
		
		return diff;
	}

	private static double calcManhattanDistance(double[] ds1, double[] ds2) {

		double result = 0;
		
		for(int i = 0; i < ds1.length; i++){
			result += Math.abs(ds1[i] - ds2[i]);
		}
		
		return result;
	}

	private static double calcEuclidDistance(double[] ds1, double[] ds2) {

		double result = 0;
		for(int i = 0; i < ds1.length; i++){
			result += Math.pow((ds1[i] - ds2[i]), 2);
		}
		
		return Math.sqrt(result);
	}
	
}
