package java_collections_example;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

// Comparator<T> 의 구현
class TreeNodeComparator implements Comparator<TreeNode> {
	
	@Override
	public int compare(TreeNode n1, TreeNode n2) {
		return n2.getI() - n1.getI();
	}
}


public class Set_example {
	
	public static void main(String[] args) {
		
		// set 컬렉션의 생성
		Set<Integer> set1 = new HashSet<>();
		
		// set 에 값 넣기
		set1.add(1);
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(3);
		
		System.out.println("set1 = " + set1);
		
		// set 의 요소 찾기
		if (set1.contains(1)) {
			System.out.println("set1 에는 1 이 있다.");
		}
		else {
			System.out.println("set1 에는 1 이 없다.");
		}
		
		if (set1.contains(4)) {
			System.out.println("set1 에는 4 이 있다.");
		}
		else {
			System.out.println("set1 에는 4 이 없다.");
		}
		
		// set 요소 순차 탐색
		for (Integer i : set1) {
			System.out.println("i = " + i);
		}
		
		for (Iterator<Integer> itr1 = set1.iterator(); itr1.hasNext(); ) {
			System.out.println("itr1.next() = " + itr1.next());
		}
		
		// set 요소 삭제
		// set 은 원시형을 래퍼 클래스로 오토 박싱 후 같은 인스턴스를 삭제한다.
		set1.remove(2);
		
		System.out.println("set1 = " + set1); // set1 = [1, 3]
		
		
		// Hash 의 동일값 판단의 기준
		Set<Num1> set2 = new HashSet<>();
		
		set2.add(new Num1(1));
		set2.add(new Num1(2));
		set2.add(new Num1(3));
		set2.add(new Num1(1));
		
		// 인스턴스의 Hash 값 판단은 Object 의 equals 와 hashcode 메소드로 판단한다.
		// Num1 은 두 메소드를 override 하지않았다.
		System.out.println("set2 = " + set2); // set2 = [1, 3, 2, 1]
		
		// Num2 은 두 메소드를 override 했다.
		Set<Num2> set3 = new HashSet<>();
		
		set3.add(new Num2(1));
		set3.add(new Num2(2));
		set3.add(new Num2(3));
		set3.add(new Num2(1));
		
		System.out.println("set3 = " + set3); // set3 = [1, 2, 3]
		
		// TreeSet 의 생성
		Set<Integer> set4 = new TreeSet<>();
		
		set4.add(1);
		set4.add(3);
		set4.add(5);
		set4.add(4);
		set4.add(6);
		set4.add(2);
		
		System.out.println("set4 = " + set4); // set4 = [1, 2, 3, 4, 5, 6]
		
		// 직접 작성한 클래스는 Comparable<T> 구현
		// compareTo 양수(본인이 더 큼) 0(같은 기준) 음수(비교대상이 더 큼)
		Set<TreeNode> set5 = new TreeSet<>();
		
		TreeNode node1 = new TreeNode(1, "name1");
		TreeNode node2 = new TreeNode(2, "name2");
		TreeNode node3 = new TreeNode(3, "name3");
		TreeNode node4 = new TreeNode(4, "name3");
		
		set5.add(node1);
		set5.add(node2);
		set5.add(node4);
		set5.add(node3);
		
		System.out.println("set5 = " + set5); // [i = 1 name = name1, i = 2 name = name2, i = 3 name = name3, i = 4 name = name3]
		
		// Comparator<T> 의 사용
		// 클래스 구현을 변경하지 않고 Set<E> 의 생성자에 전달해서 정렬 기준을 바꿈
		Set<TreeNode> set6 = new TreeSet<>(new TreeNodeComparator());
		
		set6.add(node1);
		set6.add(node2);
		set6.add(node3);
		set6.add(node4);
		
		System.out.println("set6 = " + set6); // [i = 4 name = name3, i = 3 name = name3, i = 2 name = name2, i = 1 name = name1]
		
		
		// Queue 와 Stack
		Queue<Integer> que1 = new ArrayDeque<>();
		
		// Stack 클래스는 하위 버전 지원용으로 남아있고 실제로 사용하지 않는걸 권장함
		// 권장하지 않는 클래스
		Stack<Integer> stack1 = new Stack<>();
		
		// Stack 클래스 대신 Deque 사용
		Deque<Integer> deque1 = new ArrayDeque<>();
		
		deque1.add(1);
		deque1.add(2);
		deque1.add(3);
		
	}
}
