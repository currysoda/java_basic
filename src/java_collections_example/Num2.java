package java_collections_example;

import java.util.Objects;

public class Num2 {
	
	private Integer i;
	
	public Num2() {
		this.i = 0;
	}
	
	public Num2(int i) {
		this.i = i;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.i);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Num2 num2 = (Num2) o;
		return Objects.equals(i, num2.i);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(i);
	}
}
