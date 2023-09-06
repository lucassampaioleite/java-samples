package entities;

import java.util.Objects;

public class Student {

	private String name;
	private double grade1;
	private double grade2;

	public Student(String name) {
		this.name = name;
	}

	public Student(String name, double grade1, double grade2) {
		this.name = name;
		this.grade1 = grade1;
		this.grade2 = grade2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGrade1() {
		return grade1;
	}

	public void setGrade1(double grade1) {
		this.grade1 = grade1;
	}

	public double getGrade2() {
		return grade2;
	}

	public void setGrade2(double grade2) {
		this.grade2 = grade2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(grade1, grade2, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Double.doubleToLongBits(grade1) == Double.doubleToLongBits(other.grade1)
				&& Double.doubleToLongBits(grade2) == Double.doubleToLongBits(other.grade2)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return name;
	}

}
