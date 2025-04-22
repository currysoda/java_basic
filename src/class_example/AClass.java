package class_example;

public class AClass {
	
	private        int a;
	static private int b;
	public         int c;
	
	// 초기화 블록
	{
		a = 0;
		c = 0;
	}
	
	// static 초기화 블록
	static {
		b = 0;
	}
	
	// 메소드 오버로딩
	public void print_a() {
		// ...
	}
	
	public void print_a(int a) {
		// ...
	}
	
	// 메소드 오버로딩 적용되지 않음 컴파일 오류 발생
	//	public int print_a() {
	//		// ...
	//	}
	
	public AClass() {
		this.a = 0;
		System.out.println("AClass default constructor");
	}
	
	public AClass(int a) {
		this(); // 생성자 내에서 this() 는 다른 생성자를 호출한다.
		this.a = a; // this 는 인스턴스 자신을 가리킨다.
		System.out.println("AClass another constructor");
	}
	
	public static void increase() {
		b++;
	}
	
	// 메소드 오버라이딩 예제
	public void methodOverride() {
		System.out.println("AClass method");
	}
}
