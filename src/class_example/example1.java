package class_example;

public class example1 {
	
	public static void main(String[] args) {
		
		AChildClass aChildClass = new AChildClass();
		
		aChildClass.setC(1);
		
		System.out.println("aChildClass.getC() = " + aChildClass.getC());
		
		AClass aClass1 = new AChildClass();
		
		// 메소드 오버라이딩
		aClass1.methodOverride();
		
		// static 메소드의 호출
		AClass.increase();
		
		// 정적 바인딩
		aChildClass.onlyChildMethod();
		// 컴파일 오류 예제
		//		aClass1.onlyChildMethod();
		
		// instanceof 로 런타임에 참조 변수가 실제 가리키는 객체 타입을 확인한다.
		if (aClass1 instanceof AChildClass) {
			((AChildClass) aClass1).onlyChildMethod();
		}
		
	}
	
}
