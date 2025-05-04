package stringtokenizer;

import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		
		// 문자열을 토큰 단위로 구분하는 것 두 번째 파라미터로 구분자를 입력받는다.
		StringTokenizer st1 = new StringTokenizer("PM:08:35", ":");
		
		while (st1.hasMoreTokens()) {
			System.out.println("st1.nextToken() = " + st1.nextToken());
		}
		
		System.out.println("=========================================");
		
		// 세 번째 파라미터로 true 입력시 구분자 또한 출력한다. (기본은 false)
		StringTokenizer st2 = new StringTokenizer("PM:08:35", ":", true);
		
		while (st2.hasMoreTokens()) {
			System.out.println("st2.nextToken() = " + st2.nextToken());
		}
		System.out.println("=========================================");
		
		// 구분자가 여러개일 경우 전부 두 번째 문자열에 같이 써 넣는다.
		// 공백문자도 하나의 구분자이다.
		// StringTokenizer 는 정규표현식을 쓸 수 없다. 정규 표현식을 사용해야 할 경우 String.split() 을 쓴다.
		StringTokenizer st3 = new StringTokenizer("12 + 36 - 8 / 2 = 44", "+-=/ ", true);
		
		while (st3.hasMoreTokens()) {
			System.out.println("st3.nextToken() = " + st3.nextToken());
		}
		System.out.println("=========================================");
	}
}
