package application;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListApplication {

	public static void main(String[] args) {

		LinkedList<String> list = new LinkedList<String>();
		
		System.out.println(list.isEmpty());
		list.add("Lucas");
		list.add(0, "Carlos");
		list.addAll(Arrays.asList("Marcos", "João"));
		list.addAll(0, Arrays.asList("Pedro", "Zeca"));
		
		System.out.println(list);
		
		System.out.println(list.contains("João"));
		System.out.println(list.containsAll(Arrays.asList("Pedro", "Zeca")));
		
		System.out.println();
		for (String str: list)
			System.out.println(str);
		
		System.out.println();
		list.forEach(s -> System.out.println(s));
		
		System.out.println();
		list.forEach(System.out::println);
		
		System.out.println();
		System.out.println(list.get(0));
		System.out.println(list.get(4));
		
		System.out.println(list);
		list.remove(0);
		System.out.println(list);
		list.remove(4);
		System.out.println(list);
//		list.remove(4);
//		System.out.println(list);
		
	}

}
