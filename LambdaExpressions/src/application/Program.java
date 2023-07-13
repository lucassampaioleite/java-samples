package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import entities.Student;

public class Program {

	public static void main(String[] args) {

		List<Student> list = new ArrayList<>();
		list.add(new Student("Marcos", 18, 9.0));
		list.add(new Student("Maria", 17, 9.5));
		list.add(new Student("Pedro", 23, 4.0));
		list.add(new Student("João", 14, 8.5));
		list.add(new Student("Carolina", 19, 10.0));

		// using Function to get a vector with the names of all students in upper case
		List<String> names = list.stream()
				.map(s -> s.getName().toUpperCase())
				.collect(Collectors.toList());
		names.forEach(System.out::println);
		System.out.println();

		// using Consumer to increase the age of all students
		list.forEach(s -> s.setAge(s.getAge() + 1));
		list.forEach(System.out::println);
		System.out.println();

		// Using Predicate to remove all students under the age of 18
		list.removeIf(s -> s.getAge() < 18);
		list.forEach(System.out::println);
		System.out.println();

		// using Filter to create a list with students with a grade greater than or
		// equal to 7.0
		List<Student> result = list.stream()
				.filter(s -> s.getGrade() >= 7.0)
				.collect(Collectors.toList());
		result.forEach(System.out::println);
		System.out.println();

		// Pipeline to return the average grade of students
		Double avg = list.stream()
				.map(s -> s.getGrade())
				.reduce(0.0, (s1, s2) -> s1 + s2) / list.size();
		System.out.println("Average: " + avg);
		System.out.println();

		// Pipeline to return students in alphabetical order
		List<String> listNames = list.stream().map(s -> s.getName())
				.sorted((s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase()))
				.collect(Collectors.toList());
		listNames.forEach(System.out::println);
	}

}
