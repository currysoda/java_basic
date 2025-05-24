package stream_example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	
	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 4, 5};
		
		// 스트림 예제 코드
		int result = Arrays.stream(arr1) // Arrays.stream 은 배열을 스트림으로 만들어서 반환해준다.
		                   .filter(n -> n % 2 == 0) // filter 는 중간 연산이다. stream 은 최종 연산이 없으면 중간 연산은 실행되지 않는다.
		                   .sum(); // sum() 은 자주 사용하는 stream 의 최종 연산이다.
		
		System.out.println("result = " + result); // 6
		
		// 스트림의 주요 특징
		// 한 번 사용한 스트림은 다시 사용할 수 없음
		Stream<Integer> noused = Arrays.stream(arr1).boxed();
		
		noused.forEach(s -> System.out.println("s = " + s));
		//		noused.forEach(s -> System.out.println("s = " + s)); // 주석 해제시 예외 발생 IllegalStateException
		
		
		// 스트림의 생성
		// 배열로 스트림 생성하기
		// Arrays 클래스에 stream 메소드가 있다.
		String[] sarr1 = {"String1", "String2", "String3"};
		
		Stream<String> stringStream1 = Arrays.stream(sarr1);
		
		// foreach 는 Consumer 를 매개변수로 받는 최종 연산이다.
		stringStream1.forEach(s -> System.out.println("s = " + s));
		//		s = String1
		//		s = String2
		//		s = String3
		
		// 컬렉션으로 스트림 생성하기
		List<Integer> list1 = new ArrayList<>(Arrays.asList(7, 8, 9, 10));
		
		// Collection.stream() 은 컬렉션의 요소 하나하나를 stream 에 전달한다.
		Stream<Integer> IntegerStream2 = list1.stream();
		
		// Stream.of() 에 컬렉션을 전달하면 컬렉션 통으로 하나의 요소로 stream 에 들어간다.
		Stream<List<Integer>> ListIntegerStream = Stream.of(list1);
		
		IntegerStream2.forEach(s -> System.out.println("s = " + s));
		//		s = 7
		//		s = 8
		//		s = 9
		//		s = 10
		ListIntegerStream.forEach(s -> System.out.println("s = " + s)); // s = [7, 8, 9, 10]
		
		// 필터링과 맵핑
		// 필터링 예제
		Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		stream1.filter((n) -> {
			if (n % 2 == 1) {
				return true;
			}
			else {
				return false;
			}
		}).forEach(s -> System.out.println("s = " + s)); // 1, 3, 5, 7, 9
		
		// 맵핑 예제
		Stream<String> stream2 = Stream.of("aefwef", "asdf", "waegwaegewg", "ew", "ewfewfew", "fsvcvx");
		
		stream2.map(s -> s.length())
		       .forEach(s -> System.out.println("s = " + s)); // 6, 4, 11, 2, 8, 6
		
		// 리덕션
		// 리덕션은 데이터의 수를 줄이는 연산을 말하는데 reduce() 메소드는 원하는 연산을 만들어서 전달할 수 있다.
		Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		// 리덕션의 매개변수로 전달할 연산
		BinaryOperator<Integer> sum = (a, b) -> {
			return a + b;
		};
		
		Integer result2 = stream3.reduce(0, sum);
		System.out.println("result2 = " + result2); // 55
		
		// 병렬 스트림
		List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		
		Integer i = list2.parallelStream().reduce(0, sum); // 병렬 스트림의 사용
		
		System.out.println("i = " + i); // 55
		
		// stream.of() 에서 매개변수가 컬렉션일때 배열의 차이
		// 컬렉션
		List<String> list3 = new ArrayList<>(Arrays.asList("String1", "String2", "String3"));
		
		Stream.of(list3).forEach(s -> System.out.println("s = " + s)); // s = [String1, String2, String3]
		
		// 배열
		String[] arr2 = {"String1", "String2", "String3"};
		
		Stream.of(arr2).forEach(s -> System.out.println("s = " + s));
		//		s = String1
		//		s = String2
		//		s = String3
		
		// 병렬 스트림으로 변경
		// parallel() 메소드를 붙여준다.
		Stream<String> stream4 = Arrays.stream(arr2).parallel();
		
		// isParallel() 은 병렬 스트림이면 true 를 반환하지만 스트림을 사용한다.
		System.out.println("stream4.isParallel() = " + stream4.isParallel()); // true
		
		// map 과 flatmap
		Stream<String> stream5 = list3.stream();
		
		// map 은 결과물을 자동으로 stream 으로 감싼다.
		// 따라서 중첩 스트림이 발생할 수 있다.
		Stream<Integer> stream6 = stream5.map(s -> s.length());
		
		stream6.forEach(s -> System.out.print("s = " + s + " ")); // s = 7 s = 7 s = 7
		System.out.println();
		
		// flatmap 은 결과물을 반환값을 직접 stream 으로 맞춰야 한다.
		// 중첩 스트림 문제를 해결할 수 있다.
		Stream<String> stream7 = list3.stream();
		
		Stream<Integer> stream8 = stream7.flatMap(s -> Stream.of(s.length()));
		
		// sorted 중간연산
		Stream<Integer> stream9 = Stream.of(1, 3, 5, 7, 9, 0, 3, 2, 5, 3, 4, 1).sorted();
		
		stream9.forEach(s -> System.out.print(s + " ")); // 0 1 1 2 3 3 3 4 5 5 7 9 
		System.out.println();
		
		// sorted 의 매개변수로 Comparator<T> 전달 가능
		Stream<String> stream10 = Stream.of("fdasdfasdfas", "zdsfasdfa", "asdf")
		                                .sorted((s1, s2) -> {
			                                return (s1.length() - s2.length());
		                                });
		
		stream10.forEach(s -> System.out.print(s + " ")); // asdf zdsfasdfa fdasdfasdfas
		
		// 루핑
		// 루핑은 stream 의 요소 하나하나에 각각 적용되는 연산을 말한다 대표적으로 forEach 가 있다.
		// forEach 는 최종 연산이고 중간 연산용인 peek 가 있다.
		Stream<String> stream11 = Stream.of("fdasdfasdfas", "zdsfasdfa", "asdf");
		
		// peek 는 중간연산이기 때문에 최종 연산이 없으면 실행되지 않는다.
		// 실행되지 않아도 파이프라인 구축이 일어나면 stream 은 사용된것으로 간주된다.
		stream11.peek(s -> System.out.println("실행확인"));
		
		// 최종 연산 추가
		Stream<String> stream12 = Stream.of("fdasdfasdfas", "zdsfasdfa", "asdf");
		stream12.peek(s -> System.out.println("실행확인")).forEach(s -> System.out.println("최종연산"));
		//		실행확인
		//			최종연산
		//		실행확인
		//			최종연산
		//		실행확인
		//			최종연산
		
		// 자주 쓰는 최종 연산
		Stream<String> stream13 = Stream.of("fdasdfasdfas", "zdsfasdfa", "asdf");
		long           result3  = stream13.count();
		
		System.out.println("result3 = " + result3); // result3 = 3
		
		// allMatch anyMatch noneMatch
		//`allMatch` 는 요소 모두가 조건에 맞아야 `true` 반환 `anyMatch` 는 요소 중 하나만 맞아도 `true` 반환
		// `noneMatch` 는 모든 요소가 조건에 맞지 않아야 `true` 반환
		List<Integer>   list4    = new ArrayList<>(Arrays.asList(1, 2, 3, 4, -1));
		Stream<Integer> stream14 = list4.stream();
		Stream<Integer> stream15 = list4.stream();
		Stream<Integer> stream16 = list4.stream();
		
		System.out.println("stream14.allMatch(s -> s >= 0) = " + stream14.allMatch(s -> s >= 0)); // false
		System.out.println("stream14.allMatch(s -> s >= 0) = " + stream15.anyMatch(s -> s >= 0)); // true
		System.out.println("stream14.allMatch(s -> s >= 0) = " + stream16.noneMatch(s -> s >= 0)); // false
		
		// collect
		// collect 는 스트림의 연산 최종 결과를 다른 곳에 저장할 때 사용한다.
		Stream<Integer> stream17 = list4.stream();
		// 첫 번째 매개변수는 저장할 저장소 생성 두 번째 매개변수는 저장소와 stream 의 요소 세번째 매개변수는 스트림의 연결인데 병렬 스트림에서 사용한다.
		// 세번째 매개변수는 병렬 스트림에서 사용하지만 병렬 스트림이 아니더라도 구현해야한다.(미구현시 NullPointerException)
		List<Integer> list5 = stream17.collect(() -> new ArrayList<>(),
		                                       (c, s) -> c.add(s),
		                                       (templist1, templist2) -> templist1.addAll(templist2));
		System.out.println("list5 = " + list5); // list5 = [1, 2, 3, 4, -1]
		
		// 병렬 스트림의 collect
		Stream<Integer> stream18 = list4.stream();
		// collect 의 세번째 매개변수는 병렬 스트림을 위한 것이다. 각각 처리 후 마지막에 합쳐주는 것
		List<Integer> list6 = stream18.parallel()
		                              .collect(() -> new ArrayList<>(),
		                                       (c, s) -> c.add(s),
		                                       ((templist1, templist2) -> templist1.addAll(templist2)));
		System.out.println("list6 = " + list6); // list6 = [1, 2, 3, 4, -1]
		
		
	}
}
