package generics_example;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void printList(Object o) {
		System.out.println("o = " + o);
	}
	
	public static void main(String[] args) {
		
		// 제네릭 클래스의 사용
		ClassExample<Integer> classExample1 = new ClassExample<Integer>(10);
		ClassExample<Integer> classExample2 = new ClassExample<>(20);
		
		System.out.println("classExample1.getA() = " + classExample1.getA()); // 10
		System.out.println("ClassExample<Number>.getClass() = " + classExample1.getClass()); // class generics_example.ClassExample
		
		// 제네릭 메소드의 예제 <> 타입 파라미터는 타입 추론으로 생략 가능
		System.out.println("classExample1.makeNumber(10) = " + ClassExample.<Number>makeNumber(10)); // 10
		
		// 상속 관계를 형성하는 클래스는 타입 인자가 같으면 상속 관계를 형성함
		Box<Integer> box1 = new SteelBox<Integer>(10);
		
		// 상속 관계를 형성하는 클래스는 타입 인자가 다르면 상속 관계를 형성하지 않음
		// 타입 인자끼리 상속관계를 형성하더라도 매개변수화 타입은 상속 관계를 형성하지 않는다.
		//		Box<Number> box2 = new SteelBox<Integer>(10); // 컴파일 에러 코드
		
		
		// 와일드 카드
		List<Integer> list1 = new ArrayList<>();
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		
		printList(list1);
		
	}
}
