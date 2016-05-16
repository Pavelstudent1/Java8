package lesson160331;

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
	
	@FunctionalInterface
	interface B extends A {

	}
	
	
	/**
	 *	Дескриптор функции - набор типов входных параметров и тип возвращаемого значения (имя роли не играет) 
	 */
	
	public static void main(String[] args) {
		
		
	}
}
