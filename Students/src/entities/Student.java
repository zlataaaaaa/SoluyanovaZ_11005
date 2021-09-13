package entities;

import java.util.Objects;

/**
 * Class with Student entity description
 * Created by
 *
 * @author anastasia
 * Date: 10/09/2021 20:25
 */
public class Student {
	// id студента
	private int id;
	// Имя студента
	private String firstName;
	// Фамилия студента
	private String secondName;
	// Группа
	private String group;

	public Student() {
	}

	public Student(Integer id, String firstName, String secondName, String group) {
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.group = group;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getFullName() {
		return firstName + " " + secondName;
	}

	@Override
	public String toString() {
		return "Student {id: " + id +
		       ", name: " + firstName + " " + secondName +
		       ", group: " + group +
		       "}";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Student student = (Student) o;
		return Objects.equals(firstName, student.firstName) && Objects.equals(secondName, student.secondName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, secondName);
	}
}