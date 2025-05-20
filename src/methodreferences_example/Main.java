package methodreferences_example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

class JustReverse {
	
	// 생성자 참조
	public JustReverse(List<Integer> list) {
		Collections.reverse(list);
	}
	
	public JustReverse() {
	}
	
	// 인스턴스 메소드 참조
	public void reverse(List<?> list) {
		Collections.reverse(list);
	}
	
	public void reverse2(List<Integer> list) {
		Collections.reverse(list);
	}
}


public class Main {
	
	public static void main(String[] args) {
		
		List<Integer> list1 = new ArrayList<>();
		
		list1.add(1);
		list1.add(3);
		list1.add(5);
		list1.add(7);
		list1.add(9);
		
		// static 메소드의 참조
		// 람다식 예제
		Consumer<List<Integer>> c = l -> {
			Collections.reverse(l);
		};
		
		c.accept(list1);
		System.out.println("list1 = " + list1); // [9, 7, 5, 3, 1]
		
		// 메소드 참조
		c = Collections::reverse;
		
		c.accept(list1);
		System.out.println("list1 = " + list1); // [1, 3, 5, 7, 9]
		
		// 람다식의 참조 변수 접근
		// 람다식에서 접근 가능한 참조 변수는 final 이거나 effectively final 이여야 한다.
		JustReverse justReverse = new JustReverse();
		
		c = (list) -> justReverse.reverse(list); // 람다식이 같은 지역의 참조 변수 참조함
		c.accept(list1);
		System.out.println("list1 = " + list1); // [9, 7, 5, 3, 1]
		
		// 참조 변수의 값을 바꾸면 effectively final 이 아니기 때문에 컴파일 에러가 발생한다.
		//		justReverse = null; // 주석을 해제하면 에러 발생
		
		// 인스턴스 메소드의 참조
		// 실제로 인스턴스를 생성한 경우
		// 메소드 참조는 effectively final 하지 않아도 컴파일 에러 발생하지 않는다.
		c = justReverse::reverse;
		c.accept(list1);
		System.out.println("list1 = " + list1); // [1, 3, 5, 7, 9]
		
		// 생성자 참조
		Consumer<List<Integer>> c1 = JustReverse::new; // List<Integer> 를 매개변수로 받는 생성자를 호출한다.
		//		c1 = list -> new JustReverse(list); // 이 람다식을 메소드 참조가 대신한다.
		c1.accept(list1);
		System.out.println("list1 = " + list1); // [9, 7, 5, 3, 1]
		
	}
	
}
