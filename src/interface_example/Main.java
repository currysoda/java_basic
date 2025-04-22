package interface_example;

public class Main {
	
	public static void main(String[] args) {
		
		// 인터페이스를 이용한 인스턴스 생성은 불가능
		// ainterface ainterface = new ainterface();
		
		// 추상클래스를 이용한 인스턴스 생성은 불가능
		// AbstractClassExample abstractClassExample1 = new AbstractClassExample();
		
		// 인터페이스 타입으로 참조 변수 선언 가능
		ainterface ainterface1 = new AinterfaceImpl();
		
		// 추상클래스 타입으로 참조 변수 선언 가능
		AbstractClassExample abstractClassExample1 = new AbstractClassExampleImpl();
		
		AinterfaceImpl ainterfaceImpl = new AinterfaceImpl();
		
		// 인터페이스 타입의 참조 변수
		ainterface1.print_interface(); // AinterfaceImpl_class Override method
		ainterfaceImpl.print_interface(); // AinterfaceImpl_class Override method
		//		ainterface1.only_AinterfaceImpl(); // 컴파일 타입 체크
		ainterfaceImpl.only_AinterfaceImpl(); // only AinterfaceImpl_class method
		
		// 인터페이스 static 메소드 사용
		ainterface.print_interface_static_method(); // interface static method
		
		// 마커 인터페이스 예제
		if (ainterfaceImpl instanceof MarkerInterface) {
			System.out.println("마커 인터페이스 구현 예제"); // 마커 인터페이스 구현 예제
		}
		
		// 추상 클래스의 추상 메소드 호출
		abstractClassExample1.print_abstractmethod(); // AbstractClassExampleImpl method
		
	}
}
