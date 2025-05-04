package arrays_class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
		// 자바에서 배열의 기본값은
		// int long = 0
		// double float = 0.0
		// boolean = false
		// String = null
		// 이다.
		
		// 배열의 선언
		int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] arr2 = new int[10];
		int[] arr3 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		// 2차원 배열 선언
		int[][] two_dimentional_array1 = {{1, 2, 3}, {6, 5, 4}, {7, 8, 9}};
		int[][] two_dimentional_array2 = new int[3][3];
		int[][] two_dimentional_array3 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		
		
		// 배열의 길이
		System.out.println("arr1.length = " + arr1.length);
		
		// 배열에 접근
		for (int i = 0; i < arr1.length; i++) {
			System.out.println("arr1[i] = " + arr1[i]);
		}
		
		// 2차원 배열에 접근
		for (int i = 0; i < two_dimentional_array1.length; i++) {
			for (int j = 0; j < two_dimentional_array1[i].length; j++) {
				System.out.println("two_dimentional_array1[i][j] = " + two_dimentional_array1[i][j]);
			}
		}
		
		// 배열의 복사(얕은 복사)
		int[] arr4 = Arrays.copyOf(arr1, arr1.length - 4);
		int[] arr5 = Arrays.copyOfRange(arr1, 0, arr1.length - 5);
		
		System.out.println("arr4 = " + Arrays.toString(arr4)); // arr4 = [1, 2, 3, 4, 5, 6]
		System.out.println("arr5 = " + Arrays.toString(arr5)); // arr5 = [1, 2, 3, 4, 5]
		
		// 배열의 정렬
		int[] arr6 = {1, 6, 3, 5, 8, 4, 8, 10};
		
		Arrays.sort(arr6);
		
		System.out.println("arr6 = " + Arrays.toString(arr6)); // arr6 = [1, 3, 4, 5, 6, 8, 8, 10]
		
		// 이진 탐색(정렬된 배열에서만 정상 작동)
		// index 위치를 반환한다.
		int index = Arrays.binarySearch(arr6, 1);
		
		System.out.println("arr6[index] = " + arr6[index]); // 1
		System.out.println("index = " + index); // 0
		
		// Arrays.equals
		// 기본형 String 등은 값이 같으면 동일한 것으로 간주
		// 객체 인스턴스는 equals() 와 hashcode() 를 이용한다.
		System.out.println("arr1 = " + Arrays.toString(arr1)); // arr1 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
		System.out.println("arr3 = " + Arrays.toString(arr3)); // arr3 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
		System.out.println("Arrays.equals(arr1, arr3) = " + Arrays.equals(arr1, arr3)); // true
		
		// Arrays.fill
		// 배열을 전달한 값으로 채워준다.
		System.out.println("arr2 = " + Arrays.toString(arr2)); // arr2 = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		Arrays.fill(arr2, 10);
		System.out.println("arr2 = " + Arrays.toString(arr2)); // arr2 = [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]
		
		// Arrays.asList()
		// 배열을 불변 리스트로 반환해준다. 불변 리스트는 요소의 추가 삭제가 불가능하다.
		// 일반적인 List 가 아님에 주의 List 처럼 사용하려면 불변 리스트를 ArrayList 의 생성자로 사용한다.
		Integer[]     wraparr1 = new Integer[]{1, 2, 3}; // 컬렉션은 래퍼 클래스만 인자로 가능
		List<Integer> list1    = new ArrayList<>(Arrays.asList(wraparr1));
		
		System.out.println("list1 = " + list1); // list1 = [1, 2, 3]
		
	}
}
