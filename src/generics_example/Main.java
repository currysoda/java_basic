package generics_example;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	// Object 타입으로 받는 메소드
	public static void printList_Object(Object o) {
		System.out.println("o = " + o); // o = [1, 2, 3, 4, 5]
		
		// 매개변수를 명시적 타입 형 변환 후 요소를 추가할 수 있다. 그러면 런타임에 오류가 날 수 있다.
		((ArrayList) o).add(10); // 위험한 코드가 실행된다.
		((ArrayList) o).add("String"); // Integer List 에 String 타입의 데이터가 들어감
		
		System.out.println("o = " + o); // o = [1, 2, 3, 4, 5, 10, String]
	}
	
	// 와일드 카드를 사용하는 메소드 / 조회만 가능
	public static void printList_Wildcard(List<?> list) {
		System.out.println("list = " + list); // o = [1, 2, 3, 4, 5, 10, String]
		
		// 와일드 카드로 어떤 타입이 올지 확정할 수 없기 때문에 list 에 요소를 추가할 수 없다.
		//		list.add(10); // 실행 불가능한 코드
	}
	
	// 제네릭을 이용한 메소드
	public static <T> void printList_Generics(List<T> list) {
		System.out.println("list = " + list); // o = [1, 2, 3, 4, 5, 10, String]
		
		// T 가 어떤 타입인지 확정할 수 없기 때문에 List 에 요소를 추가할 수 없다.
		//		list.add(10); // 실행 불가능한 코드
	}
	
	// 제한적 와일드카드 bounded wildcard
	// 상한 제한 와일드 카드 예제
	public static void upper_bounded_wildcard(List<? extends Number> list) {
		
		// ? 타입을 확정할 순 없지만 Number 의 하위 타입이므로 다형성으로 Number 타입으로 받을 수 있다.
		for (Number n : list) {
			System.out.println("n = " + n);
		}
		
		// 타입을 확정지을 수 없기 때문에 값을 넣을 수 없다. 
		// 런타임에서 Number 의 하위 타입 일수도 있는데 Number 값을 넣으면 에러 발생
		//		list.add(10); // 실행 불가능한 코드
	}
	
	// 하한 제한 와일드 카드 예제
	public static void lower_bounded_wildcard(List<? super Number> list) {
		
		System.out.println("list = " + list.toString()); // list = [1, 2, 3, 4, 5, 10, String]
		
		// Number 의 상위 타입은 Number 타입 변수로 받을 수 없다. 따라서 실행 불가능
		//		for (Number n : list) {  // 실행 불가능한 코드
		//			System.out.println("n = " + n);
		//		}
		
		// ? 타입을 확정지을 수 없지만 Number 의 상위 객체이기 때문에 Number 타입의 인스턴스를 받을 수 있다.
		list.add(10);
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
		List<Number> list1 = new ArrayList<>();
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		
		printList_Object(list1);
		printList_Wildcard(list1);
		printList_Generics(list1);
		
		lower_bounded_wildcard(list1);
		
		
	}
}
