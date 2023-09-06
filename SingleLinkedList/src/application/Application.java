package application;

import entities.SingleLinkedList;
import entities.Student;

public class Application {

	public static void main(String[] args) {

		SingleLinkedList list = new SingleLinkedList();

		System.out.println(list);
		list.addFirst(new Student("Lucas"));
		System.out.println(list);
		list.addFirst(new Student("Maíra"));
    	System.out.println(list);
		list.add(new Student("Pedro"));
		System.out.println(list);

		System.out.println(list.size());

		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));

		System.out.println(list);
		list.add(0, new Student("Marcos"));
		System.out.println(list);
		list.add(4, new Student("André"));
		System.out.println(list);
		list.add(2, new Student("Jorge"));
		System.out.println(list);

		System.out.println(list.contains(new Student("André")));
		System.out.println(list.contains(new Student("Zeca")));

		list.removeFirst();
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		
		list.remove(1);
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
		list.remove(0);
		System.out.println(list);
		
		System.out.println(list.size());

	}

}
