package lesson160329;

import java.util.function.Function;
import java.util.function.Supplier;

public class Example02 {
	
	static class A {
		
		A(){
			
		}
		
		A(int x){
			
		}
		
		A(int x, int y){
			
		}
	}
	
	@FunctionalInterface
	interface MySup<T> {
		T createMyIncredibleObject();
	}
	
	public static void main(String[] args) {
		
		Supplier<A> s = A::new;
		
		MySup<A> ms = A::new;
		
		A a = ms.createMyIncredibleObject();
		
		System.out.println(a);
		
	
		Function<Integer, A> f = A::new;	//по сути, конструктор - та же функция, принимает параметр 
											//типа Integer, а возвращает сконструированный объект типа A
		
		A a2 = f.apply(10);	//получается, что конструктор - это метод, позволяющий конструировать объекты.
							//Данный метод похож на фабрику, конструирующую объекты. Но конструктор жёстко
							//не зашит в метод, а передан ему снаружи.
		
		
		//Для конструктора с двум параметрами -> BiFunction<T, U, R>
		
		
		
		
		Supplier<A> s0 = new Supplier<A>() {
			@Override
			public A get() {
				return null;
			}
		};
		
		Supplier<A> s1 = () -> { 
			return new A(); 
		};
		
		
		
	}
	
}
