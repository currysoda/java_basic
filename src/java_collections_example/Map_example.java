package java_collections_example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Map_example {
	
	public static void main(String[] args) {
		
		// HashMap (Num2 는 equals 와 hashcode 를 override 함)
		Map<Integer, String> map1 = new HashMap<>();
		
		// Map 의 주요 메소드
		map1.put(1, "String1");
		map1.put(2, "String2");
		map1.put(3, "String3");
		map1.put(100, "String100");
		
		System.out.println("map1 = " + map1); // map1 = {1=String1, 2=String2, 3=String3, 100=String100}
		
		// put 은 기존 값을 덮어쓴다.
		map1.put(1, "new String1");
		
		System.out.println("map1 = " + map1); // map1 = {1=new String1, 2=String2, 3=String3, 100=String100}
		
		// putIfAbsent 는 기존 값을 덮어쓰지 않는다.
		System.out.println("map1.putIfAbsent(2, \"new String2\") = " + map1.putIfAbsent(2, "new String2"));
		
		System.out.println("map1 = " + map1); // map1 = {1=new String1, 2=String2, 3=String3, 100=String100}
		
		// for-each 탐색
		// Map.entry
		for (Map.Entry<Integer, String> entry : map1.entrySet()) {
			System.out.println("entry = " + entry);
			System.out.println("entry.getKey() = " + entry.getKey());
			System.out.println("entry.getValue() = " + entry.getValue());
		}
		
		// Map 은 Iterable<T> 를 구현하지 않는다.
		
		// key 값만 가진 set 으로 탐색
		Set<Integer> keyset = map1.keySet();
		
		System.out.println("keyset = " + keyset); // keyset = [1, 2, 3, 100]
		
		// Map.get(Object key) 는 key 값으로 value 를 찾는다.
		for (Integer i : keyset) {
			System.out.println("map1.key = " + i);
			System.out.println("map1.value = " + map1.get(i));
		}
		
		// containsKey 키 존재 여부 확인
		
		if (map1.containsKey(1)) {
			System.out.println("key : 1 은 존재한다");
		}
		else {
			System.out.println("key : 1 은 존재하지 않음");
		}
		
		if (map1.containsKey(10)) {
			System.out.println("key : 10 은 존재한다");
		}
		else {
			System.out.println("key : 10 은 존재하지 않음");
		}
		
		
		// containsValue 값 존재 여부 확인
		
		if (map1.containsValue("String3")) {
			System.out.println("value : String3 은 존재한다.");
		}
		else {
			System.out.println("value : String3 은 존재하지 않음");
		}
		
		// remove(Object key) 키 기반으로 키-값 쌍 제거
		System.out.println("map1 = " + map1); // map1 = {1=new String1, 2=String2, 3=String3, 100=String100}
		map1.remove(1);
		System.out.println("map1 = " + map1); // map1 = {2=String2, 3=String3, 100=String100}
		
		// TreeMap<K, V>
		// TreeMap 은 Key 가 정렬 상태를 유지한다.
		Map<Integer, String> map2 = new TreeMap<>();
		
		map2.put(2, "String2");
		map2.put(1, "String1");
		map2.put(4, "String4");
		map2.put(3, "String3");
		
		for (Map.Entry<Integer, String> entry : map2.entrySet()) {
			System.out.println("entry = " + entry);
			System.out.println("entry.getKey() = " + entry.getKey());
			System.out.println("entry.getValue() = " + entry.getValue());
		}
		
		// TreeMap 의 정렬 기준은 Key 를 기반으로 한다.
		//		Map<TreeNode, String> map3 = new TreeMap<>();
		// TreeMap 의 생성자로 Comparator<T> 전달시 정렬 기준을 일시적으로 바꿀 수 있다.
		Map<TreeNode, String> map3 = new TreeMap<>(new TreeNodeComparator());
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		
		map3.put(node1, "String1");
		map3.put(node2, "String2");
		map3.put(node3, "String3");
		
		System.out.println("map3 = " + map3); // Comparator<T> 구현에 따른 차이
		// map3 = {i = 1 name = default name1=String1, i = 2 name = default name2=String2, i = 3 name = default name3=String3}
		// map3 = {i = 3 name = default name3=String3, i = 2 name = default name2=String2, i = 1 name = default name1=String1}
		
		
	}
}
