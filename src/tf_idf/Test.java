package tf_idf;

public class Test {
	
	public static void main(String[] args) {
        String[] docs = new String[]{
        		"This topic describes convenience methods that you can use to register event handlers within your JavaFX application. Learn an easy way to create and register event handlers to respond to mouse events, keyboard events, action events, drag-and-drop events, window events, and others", 
        		"Some JavaFX classes define event handler properties, which provide a way to register event handlers. Setting an event handler property to a user-defined event handler automatically registers the handler to receive the corresponding event type. The setter methods for the event handler properties are convenience methods for registering event handlers"
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
