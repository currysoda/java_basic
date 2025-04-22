package class_example;

public class AChildClass extends AClass {
	
	
	public AChildClass() {
		//		super(); // 부모 생성자 호출
		System.out.println("AChildClass default constructor");
	}
	
	public int getC() {
		return this.c;
	}
	
	public void setC(int c) {
		this.c = c;
	}
	
	// 메소드 오버라이딩 예제
	// @Override 표시로 오버라이딩된 메소드임을 표시함
	@Override
	public void methodOverride() {
		System.out.println("AChildClass methodOverride");
	}
	
	// 동적 바인딩과 정적 바인딩
	public void onlyChildMethod() {
		System.out.println("AChildClass onlyChildMethod");
	}
}
