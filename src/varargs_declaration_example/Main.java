package varargs_declaration_example;

public class Main {

	// 가변 인자를 받는 메소드
	// 매개변수를 배열로 받는다.
	// 가변 인자는 마지막 매개 변수에만 사용한다. (헷갈림 방지)
	public static void printStrings(String... strs) {
		System.out.println("strs.length = " + strs.length);
		for (String str : strs) {
			System.out.println("str = " + str);
		}
	}

	public static void main(String[] args) {

		printStrings("String1", "String2", "String3");

		printStrings("String1", "String2", "String3", "String4");

		// 매개변수를 전달하지 않아도 된다.
		printStrings();

		printStrings("String1");

	}
}
