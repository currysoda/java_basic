package lambda_example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.function.Predicate;


public class Main {
	
	public static void main(String[] args) {
		// 네스티드 클래스 이너 클래스에 대한 설명은 건너뛰고 익명 클래스에서 시작
		// 익명 클래스는 클래스의 선언과 인스턴스 생성이 붙어있는 형태
		List<String> list1 = new ArrayList<>();
		
		list1.add("String1");
		list1.add("apple1");
		list1.add("zeta1");
		
		// 익명 클래스(Anonymous class)
		// 클래스의 정의와 인스턴스의 생성이 묶여있는 형태
		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		};
		
		// 익명 클래스의 사용
		Collections.sort(list1, comp);
		list1.sort(comp);
		
		System.out.println("list1 = " + list1);
		
		// 람다(lambda)
		// 람다는 코딩을 줄이고 가독성을 늘려준다.
		Printable printable1 = new Printable() {
			@Override
			public void print(String s) {
				System.out.println("s = " + s);
			}
		};
		printable1.print("anonymous class");
		
		// 람다식(lambda expression)
		// 인터페이스에 메소드가 1개뿐이다.
		Printable printable2 = (s) -> {
			System.out.println("s = " + s);
		};
		
		printable2.print("lambda expression");
		
		// 매개변수가 있고 반환형이 없는 람다식
		// 함수 몸체 중괄호 생략 매개변수 소괄호 생략
		Printable printable3 = s -> System.out.println(s);
		
		printable3.print("매개변수가 있고 반환형이 없는 람다식");
		
		// 매개변수가 있고 반환형이 있는 람다식
		// 몸체가 한줄이고 return문 이 없으면 결과를 그대로 return 하고 중괄호 생략 가능
		// return 키워드가 들어가면 중괄호 생략 불가
		StringLength stringLength1 = s -> s.length();
		
		System.out.println("s.length() = " + stringLength1.stringLength("매개변수가 있고 반환형이 있는 람다식"));
		
		// 매개변수가 두 개 이상이고 반환형이 있고 몸체가 여러줄인 람다식
		// 매개변수가 두 개 이상이면 소괄호생략 불가능
		// 몸체가 여러줄이면 중괄호 생략이 불가능하고 return 을 명시해야 한다.
		Add add1 = (a, b) -> {
			System.out.println("a = " + a);
			System.out.println("b = " + b);
			System.out.println("a + b = " + (a + b));
			return a + b;
		};
		
		// 몸체가 한 줄 이고 return 이 없으면 중괄호 생략이 가능하다.
		// 몸체의 결과를 그대로 리턴한다.
		Add add2 = (a, b) -> a + b;
		
		// 몸체가 한 줄 이고 return 이 있으면 중괄호 생략이 불가능하다.
		//		Add add3 = (a, b) -> return a + b; // 주석을 제거하면 에러 발생
		
		// 몸체가 여러줄이면 중괄호와 return 을 생략할 수 없다.
		//		Add add4 = (a, b) -> System.out.println("a + b = " + (a + b))
		//		 a + b; // 주석 생략시 에러 발생
		
		add1.add(100, 200);
		
		System.out.println("add2.add(10, 20) = " + add2.add(10, 20));
		
		// 매개변수가 없는 람다식
		// 매개변수 소괄호를 생략할 수 없음(메소드임을 표시하기 위해)
		PrintHi printHi1 = () -> System.out.println("Hi");
		
		// 람다식에 제네릭스 적용
		// 타입 정보는 참조 변수 타입으로 전달한다.
		LambdaGenerics<Integer> lambdaGenerics = (a, b) -> a + b;
		
		// 제네릭이 적용된 람다식 출력
		System.out.println("lambdaGenerics.calc(1, 2); = " + lambdaGenerics.calc(1, 2));
		
		
	}
}
