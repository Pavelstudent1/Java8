package lesson160405;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamsExamples {
	
	public static void main(String[] args) {
		
		//iterator(seed, IntUnaryOperator): seed - некое начальное значение 
		IntStream
		.iterate(1, i -> i * 2)	//начинаем с 1 и производим операцию 1 * 2
								//Полученное число используется как seed для следующей iterate и т.д.
		.limit(10)				//ограничиваем стрим от предыдущей операции до 10 элементов
		.forEachOrdered(System.out::println);	//выводим в последовательном(!) порядке
		
		//Optional, т.е. результат не гарантирован
		//Например, если список пустой, то и наибольшего в нём НЕ будет
		List<Integer> listOfIntegers = Arrays.asList(1,2,3,4,5);
		Optional<Integer> max = listOfIntegers	//неизменяемый список чисел
								.stream()					//переводим в потоки
								.map(i -> i + 1)			//мапим: каждый элемент i 
															//меняем на i + 1
								.max(Integer::compareTo);	//ищем наибольший 
		
		System.out.println(max.get());
		//Общая схема: 
		//генерация/получение данных -> цепочка трансформаций -> финализация(получение результата)
		
		OptionalInt max2 = IntStream
				.rangeClosed(1, 5)		//использовать значения от 1 до 5 с шагом +1, 
										//включая последний элемент
				.map(i -> i + 1)
				.max();
		System.out.println(max2.getAsInt());
		
		
		
		
		
		
		
		
		
		
	}
}
