package object_example.class_bucket;

import java.util.Objects;

public class CClass implements Cloneable, Comparable<CClass> {
	
	private int value;
	
	public CClass(int value) {
		this.value = value;
	}
	
	public CClass() {
	}
	
	// hashcode 오버라이드 
	// 객체 필드를 가지고 Objects.hash 메소드 호출
	@Override
	public int hashCode() {
		return Objects.hash(this.value);
	}
	
	// 두 인스턴스의 논리적 동일성 비교
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		return ((CClass) obj).getValue() == this.getValue();
	}
	
	// 깊은 복사
	@Override
	public CClass clone() throws CloneNotSupportedException {
		return new CClass(this.value);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	// 두 인스턴스를 비교할 때 사용
	// 양수 this 객체가 크다 0 두 객체가 같다. 음수 this 객체가 작다.
	@Override
	public int compareTo(CClass o) {
		return (this.value - o.value);
	}
	
	
}
