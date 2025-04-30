package object_example.class_bucket;

import java.util.Objects;

public class AClass implements Cloneable, Comparable<AClass> {
	
	private BClass b;
	
	public AClass(BClass b) {
		this.b = b;
	}
	
	public AClass() {
	}
	
	public BClass getB() {
		return b;
	}
	
	public void setB(BClass b) {
		this.b = b;
	}
	
	@Override
	protected AClass clone() throws CloneNotSupportedException {
		return new AClass(this.b.clone());
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		
		return this.b.equals(((AClass) o).b);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.b);
	}
	
	@Override
	public int compareTo(AClass o) {
		return this.b.compareTo(o.getB());
	}
}
