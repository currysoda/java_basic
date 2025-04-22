package interface_example;

public class Main {
	
	public static void main(String[] args) {
		
		// 인터페이스 타입으로 참조 변수 선언 가능
		ainterface ainterface1 = new AinterfaceImpl();
		
		AinterfaceImpl ainterfaceImpl = new AinterfaceImpl();
		
		// static
		ainterface.print_interface_static_method();
	}
}
