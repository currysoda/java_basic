package optional_example;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.function.Function;

class A {
	
	private String str;
	
	
	public A(String str) {
		this.str = str;
	}
	
	public A() {
	
	}
	
	public String getStr() {
		return str;
	}
	
	public void setStr(String str) {
		this.str = str;
	}
	
	@Override
	public String toString() {
		return "A{" +
			"str='" + str + '\'' +
			'}';
	}
}

class B {
	
	private Optional<String> name;
	
	public B() {
	}
	
	public B(String name) {
		this.name = Optional.of(name);
	}
	
	public Optional<String> getName() {
		return name;
	}
	
	public void setName(Optional<String> name) {
		this.name = name;
	}
}


public class Main {
	
	public static void main(String[] args) {
		
		
		// Optional class 의 도입
		A a1 = new A("hello world");
		
		System.out.println("a1.getStr() = " + a1.getStr()); // hello world
		
		a1 = null;
		
		// NullPointerException 발생 지점
		//		System.out.println("a1.getStr() = " + a1.getStr()); // 주석 해제시 예외 발생
		
		// NullPointerException 발생을 막으려면 검사 코드를 넣어야 한다.
		if (a1 == null) {
			System.out.println("a1.getStr() = null 입니다."); // a1.getStr() = null 입니다.
		}
		else {
			System.out.println("a1.getStr() = " + a1.getStr());
		}
		
		// Optional 인스턴스의 생성
		Optional<A> optA1 = Optional.of(new A("hello world")); // of 는 null 을 전달할 수 없다.
		Optional<A> optA2 = Optional.ofNullable(new A("hello world")); // ofNullable 은 null 을 전달할 수 있다.
		// NullPointerException 발생 코드
		//		Optional<A> optA3 = Optional.of(null); // 주석 해제시 에러 발생
		Optional<A> optA4 = Optional.ofNullable(null); // ofNullable 은 null 전달시 에러 발생하지 않음
		
		// isPresent 는 값이 존재하면 true 반환
		if (optA1.isPresent()) {
			System.out.println(optA1.get()); // A{str='hello world'}
		}
		else {
			System.out.println("값이 존재하지 않는다.");
		}
		
		// ifPresent 는 값이 존재하면 전달된 Consumer 함수를 실행한다.
		// if-isPresent 문을 ifPresent 로 줄일 수 있다.
		optA1.ifPresent(System.out::println); // A{str='hello world'}
		optA4.ifPresent(System.out::println); // 출력 결과물 없음
		
		// map 에 쓰이는 Function<T, R>
		Function<String, String> f1 = (String s) -> {
			return s.toUpperCase();
		};
		
		// flatmap 에 쓰이는 Function<T, Optional<R>>
		Function<String, Optional<String>> f2 = (String s) -> {
			return Optional.of(s.toUpperCase());
		};
		
		
		// Optional.map() 은 매개변수로 Function<T, R> 을 받는다. 연산결과로 여전히 Optional 을 반환한다.
		Optional<String> opt1 = Optional.of("String1");
		Optional<String> opt2 = opt1.map(String::toUpperCase);
		opt2 = opt1.map(f1);
		
		opt2.ifPresent(System.out::println); // STRING1
		
		// Optional.empty() 는 value 가 비어있음을 명시적으로 표시한다.
		Optional<String> opt3 = Optional.empty(); // 값이 비어있는 Optional 을 반환해준다.
		
		// orElse
		// orElse 는 값이 있으면 value 를 전달하고 없으면 orElse 매개변수를 전달한다.
		String str1 = opt2.orElse("Empty");
		System.out.println("str1 = " + str1); // str1 = STRING1
		
		String str2 = opt3.orElse("Empty");
		System.out.println("str2 = " + str2); // str2 = Empty
		
		// flatmap
		// flatmap 이 map 과 다른 점은 람다식의 반환형이다.
		// flatmap 은 map 의 중첩 Optional 문제를 해소한다.
		Optional<String> opt4 = opt1.flatMap(f2);
		System.out.println("opt4.orElse(\"Empty\") = " + opt4.orElse("Empty")); // opt4.orElse("Empty") = String1
		
		// 중첩 Optional 예제
		B b1 = new B("String1");
		
		// 중첩 Optional 예제용 Function<T, R>
		Function<String, Optional<String>> f3 = (String s) -> {
			return b1.getName();
		};
		
		Optional<String> opt5 = b1.getName();
		
		// map 을 사용할 경우
		// 결과값에 강제로 Optional 적용으로 Optional 이 중첩됨
		Optional<Optional<String>> opt6 = opt5.map(f3);
		System.out.println("opt6.get().orElse(\"Empty\") = " + opt6.get().orElse("Empty")); // opt6.get().orElse("Empty") = String1
		
		// flatmap 을 사용할 경우
		// 결과값에 Optional 을 적용하지 않는다.
		// 반환형이 Optional 이여야 하는 것은 맞으며 직접 작성해야 한다.
		Optional<String> opt7 = opt5.flatMap(f3);
		System.out.println("opt7.orElse(\"Empty\") = " + opt7.orElse("Empty")); // opt7.orElse("Empty") = String1
		
		// 기본형의 Optional
		OptionalInt    opint1   = OptionalInt.of(1);
		OptionalLong   oplong   = OptionalLong.of(100L);
		OptionalDouble opdouble = OptionalDouble.of(10.0D);
		
		opint1.ifPresent(i -> System.out.println("i = " + i));
		oplong.ifPresent(l -> System.out.println("l = " + l));
		opdouble.ifPresent(d -> System.out.println("d = " + d));
		
	}
}
















