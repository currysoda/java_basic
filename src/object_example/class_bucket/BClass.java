package object_example.class_bucket;

import java.util.Objects;

public class BClass implements Cloneable, Comparable<BClass> {
	
	private CClass c;
	
	public BClass(CClass c) {
		this.c = c;
	}
	
	public BClass() {
	}
	
	public CClass getC() {
		return c;
	}
	
	public void setC(CClass c) {
		this.c = c;
	}
	
	@Override
	protected BClass clone() throws CloneNotSupportedException {
		return new BClass(this.c.clone());
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		
		return this.c.equals(((BClass) o).c);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.c);
	}
	
	@Override
	public int compareTo(BClass o) {
		return this.c.compareTo(o.getC());
	}
}
