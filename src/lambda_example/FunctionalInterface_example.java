package lambda_example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class FunctionalInterface_example {
	
	// Predicate 는 전달된 인자를 대상으로 true, false 를 판단한다.
	public static int sum(Predicate<Integer> p, List<Integer> list) {
		int sum = 0;
		for (Integer i : list) {
			if (p.test(i)) {
				sum += i;
			}
		}
		return sum;
	}
	
	// Supplier 는 단순히 무언가를 반환한다. 매개변수로 받는 것 없음
	public static void print(Supplier<String> s) {
		System.out.println("s.get() = " + s.get());  // s.get() = Supplier 는 매개변수 없이 반환만 한다.
	}
	
	// Consumer 는 매개변수를 받아서 소모한다.
	public static void printString(Consumer<String> c) {
		c.accept("Consumer 함수형 인터페이스는 매개변수를 받아서 반환하는 것이 없다.");
		// s = Consumer 함수형 인터페이스는 매개변수를 받아서 반환하는 것이 없다.
	}
	
	// Function<T, R> 은 매개변수를 받아서 반환형을 전달한다. (함수)
	public static Integer doubleValue(Function<Integer, Integer> f, Integer i) {
		return f.apply(i); // doubleValue(n -> n * 2, 10) = 20
	}
	
	
	public static void main(String[] args) {
		
		// 미리 정의되어있는 함수형 인터페이스
		List<Integer> list1 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list1.add(i + 1);
		}
		
		// Predicate<T> 에 맞는 함수를 만들어서 전달한다.
		System.out.println("sum(n -> n % 2 == 0, list1) = " + sum(n -> n % 2 == 0, list1)); // 30
		System.out.println("sum(n -> n % 2 != 0, list1) = " + sum(n -> n % 2 != 0, list1)); // 25
		
		// Supplier 는 단순히 무언가를 반환한다. 매개변수로 전달할 것이 없다.
		print(() -> {
			return "Supplier 는 매개변수 없이 반환만 한다.";
		}); // s.get() = Supplier 는 매개변수 없이 반환만 한다.
		
		// Consumer 는 매개변수를 받아서 소모한다.(반환이 없다.)
		printString((s) -> {
			System.out.println("s = " + s); // s = Consumer 함수형 인터페이스는 매개변수를 받아서 반환하는 것이 없다.
			//			return s; // 주석 해제시 오류 발생
		});
		
		// Function<T, R> 은 매개변수를 받아서 반환형을 전달한다. (함수)
		System.out.println("doubleValue(n -> n * 2, 10) = " + doubleValue(n -> n * 2, 10)); // doubleValue(n -> n * 2, 10) = 20
		
		// 함수형 인터페이스 실제 사용
		// Collection.removeIf 를 실제로 써보자
		List<Integer> list2 = new ArrayList<>();
		
		list2.add(5);
		list2.add(10);
		list2.add(15);
		list2.add(20);
		list2.add(25);
		
		System.out.println("list2 = " + list2); // [5, 10, 15, 20, 25]
		
		list2.removeIf(e -> e % 10 == 0); // 10 으로 나눠서 나머지가 0 이면 true
		
		System.out.println("list2 = " + list2); // [5, 15, 25]
		
		
	}
}
