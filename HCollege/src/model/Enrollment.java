package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the ENROLLMENT database table.
 * 
 */
@Entity
@Table(name="ENROLLMENT", schema="testuserdb")
@NamedQuery(name="Enrollment.findAll", query="SELECT e FROM Enrollment e")
public class Enrollment implements Serializable {
	private static final long serialVersionUID = 1L;

	 @Id
	 @SequenceGenerator( name = "ENROLLMENT_SEQ", sequenceName = "ENROLLMENT_SEQ", allocationSize = 1, initialValue = 1 )
	 @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "ENROLLMENT_SEQ" )
	private long id;

	private String grade;

	//bi-directional many-to-one association to Class
	@ManyToOne
	@JoinColumn(name="CLASS_ID")
	private Class clazz;

	//bi-directional many-to-one association to EnrollStatus
	@ManyToOne
	@JoinColumn(name="ENROLL_STATUS_ID")
	private EnrollStatus enrollStatus;

	//bi-directional many-to-one association to Student
	@ManyToOne
	private Student student;

	public Enrollment() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Class getClazz() {
		return this.clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public EnrollStatus getEnrollStatus() {
		return this.enrollStatus;
	}

	public void setEnrollStatus(EnrollStatus enrollStatus) {
		this.enrollStatus = enrollStatus;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}