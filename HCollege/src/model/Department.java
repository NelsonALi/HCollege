package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the DEPARTMENT database table.
 * 
 */
@Entity
@Table(name="DEPARTMENT", schema="testuserdb")
@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	 @Id
	 @SequenceGenerator( name = "DEPARTMENT_SEQ", sequenceName = "DEPARTMENT_SEQ", allocationSize = 1, initialValue = 1 )
	 @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "DEPARTMENT_SEQ" )
	private long id;

	private String name;

	//bi-directional many-to-one association to Instructor
	@OneToMany(mappedBy="department")
	private List<Instructor> instructors;

	//bi-directional many-to-one association to Major
	@OneToMany(mappedBy="department")
	private List<Major> majors;

	public Department() {
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

	public List<Instructor> getInstructors() {
		return this.instructors;
	}

	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
	}

	public Instructor addInstructor(Instructor instructor) {
		getInstructors().add(instructor);
		instructor.setDepartment(this);

		return instructor;
	}

	public Instructor removeInstructor(Instructor instructor) {
		getInstructors().remove(instructor);
		instructor.setDepartment(null);

		return instructor;
	}

	public List<Major> getMajors() {
		return this.majors;
	}

	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}

	public Major addMajor(Major major) {
		getMajors().add(major);
		major.setDepartment(this);

		return major;
	}

	public Major removeMajor(Major major) {
		getMajors().remove(major);
		major.setDepartment(null);

		return major;
	}

}