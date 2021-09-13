package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Class with Lesson entity description
 * Class created by
 *
 * @author anastasia
 * Date: 10/09/2021 20:25
 */
public class Lesson {
	// id пары
	private int id;
	// Название предмета
	private String name;
	// Время начала пары
	private Date startDate;
	// Время окончания пары
	private Date endDate;
	// Номер аудитории
	private String auditorium;

	public Lesson() {
	}

	public Lesson(int id, String name, Date startDate, Date endDate, String auditorium) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.auditorium = auditorium;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(String auditorium) {
		this.auditorium = auditorium;
	}

	@Override
	public String toString() {
		SimpleDateFormat timeFormatForDate = new SimpleDateFormat("hh:mm");

		return "Lesson {id: " + id +
		       ", name: " + name +
		       ", start: " + timeFormatForDate.format(startDate) +
		       ", end: " + timeFormatForDate.format(endDate) +
		       ", auditorium: " + auditorium +
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

		Lesson Lesson = (Lesson) o;
		return Objects.equals(id, Lesson.id)
		       && Objects.equals(name, Lesson.name)
		       && Objects.equals(startDate, Lesson.startDate)
		       && Objects.equals(endDate, Lesson.endDate)
		       && Objects.equals(auditorium, Lesson.auditorium);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, startDate, endDate, auditorium);
	}
}