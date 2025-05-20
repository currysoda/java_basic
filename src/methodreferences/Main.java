package methodreferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Main {
	
	public static void main(String[] args) {
		
		List<Integer> list1 = new ArrayList<>();
		
		list1.add(1);
		list1.add(3);
		list1.add(5);
		list1.add(7);
		list1.add(9);
		
		Consumer<List<Integer>> c = l -> {
			Collections.reverse(l);
		};
		
		
	}
}
