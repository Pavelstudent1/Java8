package lesson160315;

public class Timing {
	
	interface Op {
		void runOp();
	}
	
	public static long time(Runnable operation){
		
		long start = System.currentTimeMillis();
		operation.run();
		long stop = System.currentTimeMillis();
		
		return stop - start;
	}
	
	public static void main(String[] args) {
		
		long elapsed = time(() -> sortBigArray());
		long elapsed2 = time(Timing::sortBigArray);
		
		System.out.println(elapsed);
		System.out.println(elapsed2);
		
		//На лямбды можно заменить любой анонимный класс с одним методом
	}

	private static void sortBigArray() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
