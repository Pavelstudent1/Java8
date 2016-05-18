package streams;

import java.util.Arrays;
import java.util.function.IntToDoubleFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class With_Arrays {
	
	
	public static void main(String[] args) {
		
		double[] a = new double[] {1.0, 2.0, 3.0, 4.0, 5.0}; 
		double[] b = new double[] {2.5, 7.1, 1.12, 5.6, 10.0};
		
		double[] result1 = new double[a.length];
		IntStream.range(0, a.length).forEach(i -> result1[i] = Math.pow((a[i] - b[i]), 2));
		System.out.println(Arrays.toString(result1));
		
		System.out.println("1 ============================");
		
		Arrays.stream(result1).mapToObj(d -> String.format("%.2f", d)).forEach(System.out::println);
		
		System.out.println("2 ============================");
		
		Arrays.stream(result1).forEach(d -> System.out.printf("%.2f ", d));
		
		System.out.println("\n3 ============================");
		
		double[] result2 = IntStream
				.range(0, a.length)
				.mapToDouble(i -> Math.pow((a[i] - b[i]), 2))
				.toArray();
		Arrays.stream(result1).forEach(d -> System.out.printf("%.3f ", d));
		
		
		System.out.println("\n4 ==========================");
		
		int[] a2 = new int[] {1, 2, 3, 4, 5}; 
		int[] b2 = new int[] {5, 7, 12, 6, 10};
		int[] result3 = IntStream.range(0, a.length).map(i -> a2[i] + b2[i]).toArray();
		System.out.println(Arrays.toString(result3));
		
		System.out.println("5 ==========================");
		
		double[] a3 = new double[] {1.0, 2.0};
		double[] b3 = new double[] {5.0, 3.0};
		
		double result4 = IntStream
				.range(0, a3.length)
				.mapToDouble(i -> Math.pow((a3[i] - b3[i]), 2))
				.reduce((d1, d2) -> d1 + d2)	//берём первые два значения из стрима, складываем их и кладём обратно 
												//(число элементов уменьшилось на 1)
												//зетем берём только что положенное и следующее и повторяем сложение и возврат.
												//Повторяем, пока не останется одно значение
				.getAsDouble();
		System.out.println(Math.sqrt(result4));
		
		System.out.println("6 ==========================");
		
		double[] array1 = new double[] {2.2, 3.9, 0.31, 5.568};
		Arrays.setAll(array1, i -> array1[i] * 2);	//здесь, i предоставляется извне, и инкрементно увеличивается: аналог for
		System.out.println(Arrays.toString(array1));
		
		
		
	}
}
