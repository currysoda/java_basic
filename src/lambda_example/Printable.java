package lambda_example;

// 람다를 위한 인터페이스
// 추상 메소드가 하나뿐이다.
@FunctionalInterface // 함수형 인터페이스 선언 메소드를 하나만 둘 수 있음
public interface Printable {
	
	public void print(String s);
	
	// 함수형 인터페이스에서 메소드 2개 이상이면 컴파일 에러 발생
	//	public void input(String s); // 주석 해제시 에러 발생
	
}
