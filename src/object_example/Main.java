package object_example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import object_example.class_bucket.AClass;
import object_example.class_bucket.BClass;
import object_example.class_bucket.CClass;

public class Main {
	
	public static void main(String[] args) {
		
		CClass c1 = new CClass(10);
		BClass b1 = new BClass(c1);
		AClass a1 = new AClass(b1);
		
		CClass c2 = new CClass(10);
		CClass c3 = new CClass(20);
		
		BClass b2 = new BClass(c2);
		BClass b3 = new BClass(c3);
		
		AClass a2 = new AClass(b2);
		AClass a3 = new AClass(b3);
		
		System.out.println("a1.getB().getC().getValue() = " + a1.getB().getC().getValue());
		System.out.println("a2.getB().getC().getValue() = " + a2.getB().getC().getValue());
		System.out.println("a3.getB().getC().getValue() = " + a3.getB().getC().getValue());
		
		
		if (c1.equals(c2)) {
			System.out.println("c1 == c2");
		}
		
		if (a1.equals(a2)) {
			System.out.println("a1 == a2");
		}
		
		if (a1.equals(a3)) {
			System.out.println("a1 == a3");
		}
		
		List<AClass> list = new ArrayList<>();
		
		list.add(a3);
		list.add(a1);
		
		Collections.sort(list);
		
		for (AClass temp : list) {
			System.out.println("temp.getB().getC().getValue() = " + temp.getB().getC().getValue());
		}
	}
}
