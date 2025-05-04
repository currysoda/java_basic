package generics_example;

public class SteelBox<T> extends Box<T> {
	
	private T a;
	
	public SteelBox() {
	}
	
	public SteelBox(T t) {
		this.a = t;
	}
	
	public T getA() {
		return a;
	}
	
	public void setA(T a) {
		this.a = a;
	}
}
