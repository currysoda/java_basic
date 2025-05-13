package enum_example;

// enum 의 필드 생성자 메소드 사용 예제
public enum Day {
	MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);
	
	private final int code;
	
	Day(int i) {
		this.code = i;
	}
	
	public int getCode() {
		return this.code;
	}
	
	// setter 메소드는 작성하지 말것
	// final 을 지우고 setter 를 작성하면 작동하지만 Enum 클래스 특성상 쓰지 않는것이 좋다.
}
