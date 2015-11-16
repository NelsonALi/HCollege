package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the STUDENT database table.
 * 
 */
@Entity
@Table(name="STUDENT", schema="TESTUSERDB")
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	 @Id
	 @SequenceGenerator( name = "STUDENT_SEQ", sequenceName = "STUDENT_SEQ", allocationSize = 1, initialValue = 1 )
	 @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "STUDENT_SEQ" )
	private long id;

	private String addr;

	private String email;

	private String name;

	@Column(name="STUDENT_NO")
	private String studentNo;

	@Column(name="YR_ENTRY")
	private String yrEntry;

	//bi-directional many-to-one association to Enrollment
	@OneToMany(mappedBy="student")
	private List<Enrollment> enrollments;

	//bi-directional many-to-one association to Major
	@ManyToOne
	private Major major;

	public Student() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentNo() {
		return this.studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getYrEntry() {
		return this.yrEntry;
	}

	public void setYrEntry(String yrEntry) {
		this.yrEntry = yrEntry;
	}

	public List<Enrollment> getEnrollments() {
		return this.enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public Enrollment addEnrollment(Enrollment enrollment) {
		getEnrollments().add(enrollment);
		enrollment.setStudent(this);

		return enrollment;
	}

	public Enrollment removeEnrollment(Enrollment enrollment) {
		getEnrollments().remove(enrollment);
		enrollment.setStudent(null);

		return enrollment;
	}

	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

}