package interface_example;

// 추상 클래스의 구현 클래스
public class AbstractClassExampleImpl extends AbstractClassExample {
	
	// 추상 클래스의 추상 메소드를 오버라이드
	@Override
	public void print_abstractmethod() {
		System.out.println("AbstractClassExampleImpl method");
	}
}
