package lesson160331;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Функциональный интерфейс - интерфейс с одним и только одним абстрактным методом 
 * (но может иметь много дефолтных)
 *
 */

public class FuncInterfaceExample {
	
//	@FunctionalInterface
//	interface Nothing{
//		нет метода -> не функциональный
//	}
	
	@FunctionalInterface
	interface A {
		void m();
	}
	
//	@FunctionalInterface
//	interface B extends A {
//		void m2();
//	}
	
	
	/**
	 *	Дескриптор функции - набор типов входных параметров и тип возвращаемого значения (имя роли не играет) 
	 * @throws Exception 
	 */
	
	public static void main(String[] args) throws Exception {
		
		Callable<Integer> c = () -> 42;	//аналог new Callable<Integer>() {
//													@Override
//													public Integer call() throws Exception {
//														return 42;
//													}
//												};
		System.out.println(c.call());
		
		PrivilegedAction<Integer> p = () -> 42;
		System.out.println(p.run());
		
		launch(c);			//можно
//		launch(p);			//нельзя: несовпадение типов
		launch(p::run);		//уже можно, т.к. берётся ссылка на функцию, а она не смотрит на имя метода, 
							//а смотрит на типы параметров и возвр. значения (совпадение функц. дескриптора)
		launch(() -> 42);	//можно
		
		
//		Object o = () -> 42;	//хоть лямбда выражение и объект, но ссылку на него можно присвоить
								//только переменной функционального интерфейса!!!
		
		
		List<String> list = new ArrayList<>();
		Predicate<String> p2 = (s) -> list.add(s);
		Predicate<String> p3 = list::add;
		
		Consumer<String> c0 = list::add;	//спец. правило совместимости с void, если возвращаемое значение
											//нужно/можно проигнорировать
		
	}
	
	
	static void launch(Callable<?> c){
		try {
			System.out.println(c.call());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
