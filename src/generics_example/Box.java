package generics_example;

public class Box<T> {
	
	private T a;
	
	public Box() {
	}
	
	public Box(T t) {
		this.a = t;
	}
	
	public T getA() {
		return a;
	}
	
	public void setA(T a) {
		this.a = a;
	}
}
