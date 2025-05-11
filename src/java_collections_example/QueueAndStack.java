package java_collections_example;

import java.util.ArrayDeque;
import java.util.Deque;
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
		
		System.out.println("deque1 = " + deque1);
		
		// ArrayDeque 이 제공하는 메소드
		// 문제상황에서 예외를 발생시키는 메소드
		deque1.add(6); //
		deque1.remove();
		
		deque1.addFirst(0);
		deque1.removeFirst();
		deque1.getFirst();
		
		deque1.addLast(6);
		deque1.removeLast();
		deque1.getLast();
		
		// 예외 발생 예시
		
		
		// 문세상황에서 특정값(false, null) 반환하는 메소드
		
		deque1.offerFirst(0);
		deque1.offer();
		deque1.pollFirst();
		deque1.poll();
		
		
	}
	
}
