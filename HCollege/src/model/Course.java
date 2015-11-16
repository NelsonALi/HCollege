package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the COURSE database table.
 * 
 */
@Entity
@Table(name="COURSE", schema="testuserdb")
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	 @Id
	 @SequenceGenerator( name = "COURSE_SEQ", sequenceName = "COURSE_SEQ", allocationSize = 1, initialValue = 1 )
	 @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "COURSE_SEQ" )
	private long id;

	@Column(name="COURSE_DESCRIPTION")
	private String courseDescription;

	@Column(name="COURSE_NAME")
	private String courseName;

	@Column(name="COURSE_NO")
	private String courseNo;

	@Column(name="NUM_CREDIT")
	private String numCredit;

	@Column(name="SUBJECT_CODE")
	private String subjectCode;

	//bi-directional many-to-one association to Class
	@OneToMany(mappedBy="course")
	private List<Class> clazzs;

	public Course() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCourseDescription() {
		return this.courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseNo() {
		return this.courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	public String getNumCredit() {
		return this.numCredit;
	}

	public void setNumCredit(String numCredit) {
		this.numCredit = numCredit;
	}

	public String getSubjectCode() {
		return this.subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public List<Class> getClazzs() {
		return this.clazzs;
	}

	public void setClazzs(List<Class> clazzs) {
		this.clazzs = clazzs;
	}

	public Class addClazz(Class clazz) {
		getClazzs().add(clazz);
		clazz.setCourse(this);

		return clazz;
	}

	public Class removeClazz(Class clazz) {
		getClazzs().remove(clazz);
		clazz.setCourse(null);

		return clazz;
	}

}