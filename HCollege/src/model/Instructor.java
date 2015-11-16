package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the INSTRUCTOR database table.
 * 
 */
@Entity
@Table(name="INSTRUCTOR", schema="TESTUSERDB")
@NamedQuery(name="Instructor.findAll", query="SELECT i FROM Instructor i")
public class Instructor implements Serializable {
	private static final long serialVersionUID = 1L;

	 @Id
	 @SequenceGenerator( name = "INSTRUCTOR_SEQ", sequenceName = "INSTRUCTOR_SEQ", allocationSize = 1, initialValue = 1 )
	 @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "INSTRUCTOR_SEQ" )
	private long id;

	@Column(name="EMP_NO")
	private String empNo;

	private String name;

	@Column(name="OFFICE_ROOM")
	private String officeRoom;

	//bi-directional many-to-one association to Class
	@OneToMany(mappedBy="instructor")
	private List<Class> clazzs;

	//bi-directional many-to-one association to Department
	@ManyToOne
	@JoinColumn(name="DEPT_ID")
	private Department department;

	public Instructor() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmpNo() {
		return this.empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOfficeRoom() {
		return this.officeRoom;
	}

	public void setOfficeRoom(String officeRoom) {
		this.officeRoom = officeRoom;
	}

	public List<Class> getClazzs() {
		return this.clazzs;
	}

	public void setClazzs(List<Class> clazzs) {
		this.clazzs = clazzs;
	}

	public Class addClazz(Class clazz) {
		getClazzs().add(clazz);
		clazz.setInstructor(this);

		return clazz;
	}

	public Class removeClazz(Class clazz) {
		getClazzs().remove(clazz);
		clazz.setInstructor(null);

		return clazz;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}