package java_collections_example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Objects;

public class List_example {
	
	public static void main(String[] args) {
		
		// 컬렉션 생성
		// ArrayList 생성
		java.util.List<Integer> list1 = new ArrayList<>(10); // 초기 크기 설정
		
		// LinkedList 생성
		java.util.List<Integer> list2 = new LinkedList<>();
		
		for (int i = 0; i < 10; i++) {
			// 컬렉션에 값 넣기 1 ~ 10
			list1.add(i + 1);
		}
		
		// index 기반 값의 삭제 (int 원시형을 사용함)
		// int 원시형을 넣을 시 index 기반 삭제를 하는 것은 List 뿐이다.
		// index 1 위치의 값이 삭제됨 (2)
		list1.remove(1);
		
		// 인스턴스 기반 값의 삭제
		// 실제 Integer 의 값이 1 인 인스턴스가 삭제됨
		list1.remove(Integer.valueOf(1));
		
		
		// List.size() 요소의 갯수를 리턴한다.
		System.out.println("list1.size() = " + list1.size());
		
		// 전체 요소에 접근 index 기반의 값 읽기
		for (int i = 0; i < list1.size(); i++) {
			
			// index 의 값 읽기
			System.out.println("list1.get(i) = " + list1.get(i));
		}
		
		// List.get() 으로 index 밖의 값을 검색할 경우
		//		System.out.println("list1.get(list1.size() + 1) = " + list1.get(list1.size() + 1)); // indexOutOfBoundsException 발생
		
		// 값 기반으로 index 찾기
		// 값이 존재하면 index 값 반환
		System.out.println("list1.indexOf(Integer.valueOf(3)) = " + list1.indexOf(Integer.valueOf(3))); // 0
		
		// 값이 존재하지 않으면 음수 값 반환
		System.out.println("list1.indexOf(Integer.valueOf(100)) = " + list1.indexOf(Integer.valueOf(100))); // -1
		
		// 값 수정하기
		// List.set(int index, E element)
		list1.set(list1.size() - 1, 11);
		
		
		System.out.println("list1 = " + list1); // list1 = [3, 4, 5, 6, 7, 8, 9, 11]
		
		// 원하는 값의 위치 찾기 (브루트 포스)
		int index  = -1;
		int answer = 11;
		for (int i = 0; i < list1.size(); i++) {
			if (Objects.equals(list1.get(i), answer)) {
				index = i;
				System.out.println("index = " + index);
			}
		}
		
		
		java.util.List<Integer> list3 = new ArrayList<>();
		
		list3.add(1);
		list3.add(2);
		list3.add(3);
		list3.add(4);
		list3.add(5);
		list3.add(5);
		
		// iterator 의 생성
		Iterator<Integer> itr = list3.iterator();
		
		// iterator 를 이용한 순차 참조
		while (itr.hasNext()) {
			
			// iterator 를 이용한 인스턴스 삭제
			if (Objects.equals(itr.next(), Integer.valueOf(5))) {
				itr.remove();
			}
			//			System.out.println("itr.next() = " + itr.next());
		}
		
		System.out.println("list3 = " + list3); // list3 = [1, 2, 3, 4]
		
		// index 기반 삭제시 주의해야 할 점
		list3 = new ArrayList<>();
		
		list3.add(1);
		list3.add(2);
		list3.add(3);
		list3.add(4);
		list3.add(5);
		list3.add(5);
		
		// 중간 요소가 삭제됐지만 i 값은 그대로 증가해서 요소를 건너뛸 위험이 있다.
		for (int i = 0; i < list3.size(); i++) {
			if (Objects.equals(list3.get(i), Integer.valueOf(5))) {
				list3.remove(i);
				// 요소가 삭제된다면 i 값을 조절해야 한다.
				//				i--;
			}
		}
		
		System.out.println("list3 = " + list3);
		
		// asList 로 List 를 만들 경우 요소의 삭제 추가가 안된다.
		java.util.List<String> list4 = Arrays.asList("String1", "String2", "String3");
		
		// 런타임에 오류 발생 
		//		list4.add("String4"); // 주석 제거시 오류 발생
		//		list4.remove(0);
		
		// asList 의 반환형이 java.util.Arrays$ArrayList 인 문제
		// 다시 ArrayList 등으로 변경해서 사용한다.
		list4 = new ArrayList<>(Arrays.asList("String1", "String2", "String3"));
		
		list4.add("String4");
		list4.remove(0);
		
		System.out.println("list4 = " + list4); // list4 = [String2, String3, String4]
		
		// list1 = [3, 4, 5, 6, 7, 8, 9, 11]
		// List 의 양방향 iterator
		ListIterator<Integer> listItr1 = list1.listIterator();
		
		while (listItr1.hasNext()) {
			if (Objects.equals(listItr1.next(), 7)) {
				listItr1.remove();
				listItr1.add(100);
			}
			
			if (Objects.equals(listItr1.next(), 9)) {
				listItr1.set(999);
			}
		}
		
		System.out.println("list1 = " + list1); // list1 = [3, 4, 5, 6, 100, 8, 9, 11]
		
		
	}
}
