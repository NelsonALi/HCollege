package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the MAJOR database table.
 * 
 */
@Entity
@Table(name="MAJOR", schema="TESTUSERDB")
@NamedQuery(name="Major.findAll", query="SELECT m FROM Major m")
public class Major implements Serializable {
	private static final long serialVersionUID = 1L;

	 @Id
	 @SequenceGenerator( name = "MAJOR_SEQ", sequenceName = "MAJOR_SEQ", allocationSize = 1, initialValue = 1 )
	 @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "MAJOR_SEQ" )
	private long id;

	private String name;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="DEPT_ID")
	private Department department;

	//bi-directional many-to-one association to Student
	@OneToMany(mappedBy="major")
	private List<Student> students;

	public Major() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Student addStudent(Student student) {
		getStudents().add(student);
		student.setMajor(this);

		return student;
	}

	public Student removeStudent(Student student) {
		getStudents().remove(student);
		student.setMajor(null);

		return student;
	}

}