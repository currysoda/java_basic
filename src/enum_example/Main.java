package enum_example;

public class Main {
	
	public static void main(String[] args) {
		
		Shape s1 = Shape.Circle;
		Shape s2 = Shape.Rectangle;
		Shape s3 = Shape.triangle;
		
		// Enum 의 toString 으로 출력되는 것은 Enum 타입의 실제값이 아니다.
		// Enum 의 실제값은 .ordinal() 메소드로 출력되는 것이 실제값이다.
		System.out.println("s1 = " + s1);
		System.out.println("s1.ordinal() = " + s1.ordinal());
		System.out.println("s2 = " + s2);
		System.out.println("s2.ordinal() = " + s2.ordinal());
		System.out.println("s3 = " + s3);
		System.out.println("s3.ordinal() = " + s3.ordinal());
		
		Day day1 = Day.MONDAY;
		Day day2 = Day.TUESDAY;
		
		System.out.println("day1 = " + day1.toString());
		System.out.println("day1.ordinal() = " + day1.ordinal());
		System.out.println("day1.getCode() = " + day1.getCode());
	}
}
