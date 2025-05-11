package java_collections_example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;

public class QueueAndStack {
	
	public static void main(String[] args) {
		
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
		deque1.add(5);
		deque1.add(4);
		
		System.out.println("deque1 = " + deque1); // deque1 = [1, 2, 3, 5, 4]
		
		// ArrayDeque 이 제공하는 메소드
		// 문제상황에서 예외를 발생시키는 메소드
		// 메소드에 First Last 가 붙지 않으면 Queue 로 작동함 (배열의 뒤에 삽입 배열의 앞에서 삭제 peek 은 맨 앞 요소 리턴)
		deque1.add(6); // addLast 와 같음
		System.out.println("deque1 = " + deque1); // deque1 = [1, 2, 3, 5, 4, 6]
		deque1.remove(); //  removeFirst 와 같음
		System.out.println("deque1 = " + deque1); // deque1 = [2, 3, 5, 4, 6]
		
		deque1.addFirst(0);
		System.out.println("deque1 = " + deque1); // deque1 = [0, 2, 3, 5, 4, 6]
		deque1.removeFirst();
		System.out.println("deque1 = " + deque1); // deque1 = [2, 3, 5, 4, 6]
		System.out.println("deque1.getFirst() = " + deque1.getFirst()); // 2
		
		deque1.addLast(6);
		System.out.println("deque1 = " + deque1); // deque1 = [2, 3, 5, 4, 6, 6]
		deque1.removeLast();
		System.out.println("deque1 = " + deque1); // deque1 = [2, 3, 5, 4, 6]
		System.out.println("deque1.getLast() = " + deque1.getLast()); // 6
		
		
		// 예외 발생 예시
		int count = deque1.size();
		for (int i = 0; i < count; i++) {
			deque1.remove();
		}
		
		try {
			deque1.remove();
		}
		catch (NoSuchElementException e) {
			System.out.println("remove() 예외 발생 : " + e); // remove() 예외 발생 : java.util.NoSuchElementException
		}
		
		try {
			deque1.getFirst();
		}
		catch (NoSuchElementException e) {
			System.out.println("getFirst() 예외 발생 : " + e); // getFirst() 예외 발생 : java.util.NoSuchElementException
		}
		
		
		Deque<Integer> deque2 = new ArrayDeque<>();
		
		deque2.add(1);
		deque2.add(2);
		deque2.add(3);
		deque2.add(5);
		deque2.add(4);
		
		// 문세상황에서 특정값(false, null) 반환하는 메소드
		
		deque2.offer(0); // offerLast 와 같음
		System.out.println("deque2 = " + deque2); // deque2 = [1, 2, 3, 5, 4, 0]
		deque2.poll(); // pollFirst 와 같음
		System.out.println("deque2 = " + deque2); // deque2 = [2, 3, 5, 4, 0]
		// peek은 peekFirst 와 같음
		System.out.println("deque2.peek() = " + deque2.peek()); // deque2.peek() = 2
		
		deque2.offerFirst(0);
		System.out.println("deque2 = " + deque2); // deque2 = [0, 2, 3, 5, 4, 0]
		deque2.pollFirst();
		System.out.println("deque2 = " + deque2); // deque2 = [2, 3, 5, 4, 0]
		System.out.println("deque2.peekFirst() = " + deque2.peekFirst()); // deque2.peekFirst() = 2
		
		deque2.offerLast(10);
		System.out.println("deque2 = " + deque2); // deque2 = [2, 3, 5, 4, 0, 10]
		deque2.pollLast();
		System.out.println("deque2 = " + deque2); // deque2 = [2, 3, 5, 4, 0]
		System.out.println("deque2.peekLast() = " + deque2.peekLast()); // deque2.peekLast() = 0
		
		System.out.println("deque2 = " + deque2); // deque2 = [2, 3, 5, 4, 0]
		
		// 꺼낼 대상이 없으면 null 반환
		
		count = deque2.size();
		
		for (int i = 0; i < count; i++) {
			deque2.poll();
		}
		
		System.out.println("deque2.poll() = " + deque2.poll()); // deque2.poll() = null
		System.out.println("deque2.peek() = " + deque2.peek()); // deque2.peek() = null
		
		
		deque2.add(1);
		deque2.add(2);
		deque2.add(3);
		deque2.add(5);
		deque2.add(4);
		
		// for 순회
		for (int i = 0; i < deque2.size(); i++) {
			// ArrayDeque 은 index 기반 접근을 지원하지 않음
			//			System.out.println("deque2 = " + deque2[i]); // 컴파일 에러 코드
		}
		
		// for-each 순회
		for (Integer i : deque2) {
			System.out.println("i = " + i);
		}
		
		// iterator 순회
		Iterator<Integer> itr = deque2.iterator();
		
		while (itr.hasNext()) {
			System.out.println("itr.next() = " + itr.next());
		}
	}
	
}
