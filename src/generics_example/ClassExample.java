package generics_example;

// 제네릭 클래스 정보
public class ClassExample<T extends Number> {
	
	private T a;
	
	public ClassExample() {
	}
	
	public ClassExample(T a) {
		this.a = a;
	}
	
	public T getA() {
		return a;
	}
	
	public void setA(T a) {
		this.a = a;
	}
	
	// 인스턴스 메소드는 인스턴스 생성시 제네릭 정보를 따라간다.
	public T mamakeNumber(T t) {
		return t;
	}
	
	// 클래스 메소드(static method) 는 따로 <T> 선언(제네릭 선언)이 필요하다.
	// 왜냐하면 클래스 메소드는 인스턴스 생성 없이 사용될 수 있기 때문에 따로 제네릭 정보를 받아야 한다.
	public static <T extends Number> T makeNumber(T t) {
		return t;
	}
	
	
}
