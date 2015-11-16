package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the "CLASS" database table.
 * 
 */
@Entity
@Table(name="CLASS", schema="testuserdb")
@NamedQuery(name="Class.findAll", query="SELECT c FROM Class c")
public class Class implements Serializable {
	private static final long serialVersionUID = 1L;

	 @Id
	 @SequenceGenerator( name = "CLASS_SEQ", sequenceName = "CLASS_SEQ", allocationSize = 1, initialValue = 1 )
	 @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "CLASS_SEQ" )
	private long id;

	private String crn;

	@Column(name="SCHEDULE_DATE")
	private String scheduleDate;

	@Column(name="SCHEDULE_TIME")
	private String scheduleTime;

	//bi-directional many-to-one association to Course
	@ManyToOne
	private Course course;

	//bi-directional many-to-one association to Instructor
	@ManyToOne
	private Instructor instructor;

	//bi-directional many-to-one association to Room
	@ManyToOne
	private Room room;

	//bi-directional many-to-one association to Enrollment
	@OneToMany(mappedBy="clazz")
	private List<Enrollment> enrollments;

	public Class() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCrn() {
		return this.crn;
	}

	public void setCrn(String crn) {
		this.crn = crn;
	}

	public String getScheduleDate() {
		return this.scheduleDate;
	}

	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public String getScheduleTime() {
		return this.scheduleTime;
	}

	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Instructor getInstructor() {
		return this.instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public List<Enrollment> getEnrollments() {
		return this.enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public Enrollment addEnrollment(Enrollment enrollment) {
		getEnrollments().add(enrollment);
		enrollment.setClazz(this);

		return enrollment;
	}

	public Enrollment removeEnrollment(Enrollment enrollment) {
		getEnrollments().remove(enrollment);
		enrollment.setClazz(null);

		return enrollment;
	}

}