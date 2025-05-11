package java_collections_example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Number1 implements Comparable<Number1> {
	
	private int i;
	
	public Number1(int i) {
		this.i = i;
	}
	
	public Number1() {
		this.i = 0;
	}
	
	public int getI() {
		return i;
	}
	
	public void setI(int i) {
		this.i = i;
	}
	
	@Override
	public int compareTo(Number1 num1) {
		return (this.i - num1.getI());
	}
	
	
	@Override
	public String toString() {
		return "Number1{" +
			"i=" + i +
			'}';
	}
}

class Number1Comp implements Comparator<Number1> {
	
	@Override
	public int compare(Number1 num1, Number1 num2) {
		return num2.getI() - num1.getI();
	}
}

public class Collections_example {
	
	public static void main(String[] args) {
		
		// Collections 클래스에 구현된 메소드의 사용
		List<Integer> list1 = new ArrayList<>();
		
		list1.add(1);
		list1.add(5);
		list1.add(4);
		list1.add(2);
		list1.add(3);
		
		System.out.println("list1 = " + list1); // list1 = [1, 5, 4, 2, 3]
		
		// 오름차순 정렬
		Collections.sort(list1);
		
		System.out.println("list1 = " + list1); // list1 = [1, 2, 3, 4, 5]
		
		// List 를 뒤집는다.
		Collections.reverse(list1);
		
		System.out.println("list1 = " + list1); // list1 = [5, 4, 3, 2, 1]
		
		// binarysearch 는 정렬된 list 를 기반으로 정상 작동하고 index 값을 반환한다. 존재하지 않으면 음수값 반환
		int index1 = Collections.binarySearch(list1, 3);
		int index2 = Collections.binarySearch(list1, 100);
		
		System.out.println("index1 = " + index1); // 2
		System.out.println("index2 = " + index2); // 음수
		
		// Comparator<T> 의 사용
		List<Number1> list2 = new ArrayList<>();
		Number1Comp   comp  = new Number1Comp();
		
		Number1 number1 = new Number1(1);
		Number1 number2 = new Number1(2);
		Number1 number3 = new Number1(3);
		
		list2.add(number1);
		list2.add(number2);
		list2.add(number3);
		
		System.out.println("list2 = " + list2);
		
		Collections.sort(list2, comp);
		
		System.out.println("list2 = " + list2);
		
		// copy
		List<Integer> list3 = new ArrayList<>();
		
		for (int i = 0; i < list1.size(); i++) {
			list3.add(0);
		}
		
		System.out.println("list1 = " + list1); // list1 = [5, 4, 3, 2, 1]
		System.out.println("list3 = " + list3); // list3 = [0, 0, 0, 0, 0]
		
		// copy(목적지, 출발지)
		Collections.copy(list3, list1);
		
		System.out.println("list1 = " + list1); // list1 = [5, 4, 3, 2, 1]
		System.out.println("list3 = " + list3); // list3 = [5, 4, 3, 2, 1]
		
		
	}
}
