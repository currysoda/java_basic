package interface_example;

public interface ainterface {
	
	// 인터페이스 변수
	int INTERFACE_VARIABLE = 100;
	
	// 인터페이스의 추상 메소드
	void print_interface();
	
	// 인터페이스의 디폴트 메소드
	default void print_interface_default_method() {
		System.out.println("interface default method");
	}
	
	// 인터페이스의 static 메소드
	static void print_interface_static_method() {
		System.out.println("interface static method");
	}
	
}
