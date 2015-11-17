package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HCLASS database table.
 * 
 */
@Entity
@NamedQuery(name="Hclass.findAll", query="SELECT h FROM Hclass h")
public class Hclass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HCLASS_CLASSNUM_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HCLASS_CLASSNUM_GENERATOR")
	private long classnum;

	private String crn;

	private BigDecimal enrollmenthold;

	//bi-directional many-to-one association to Hclassroom
	@ManyToOne
	@JoinColumn(name="ROOMID")
	private Hclassroom hclassroom;

	//bi-directional many-to-one association to Hcourse
	@ManyToOne
	@JoinColumn(name="COURSECODE")
	private Hcourse hcourse;

	//bi-directional many-to-one association to Hinstructor
	@ManyToOne
	@JoinColumn(name="INSTRUCTORNUM")
	private Hinstructor hinstructor;

	//bi-directional many-to-one association to Hschedule
	@ManyToOne
	@JoinColumn(name="SCHEDULECODE")
	private Hschedule hschedule;

	//bi-directional many-to-one association to Hsemester
	@ManyToOne
	@JoinColumn(name="SEMESTERCODE")
	private Hsemester hsemester;

	//bi-directional many-to-one association to Henrollment
	@OneToMany(mappedBy="hclass")
	private List<Henrollment> henrollments;

	public Hclass() {
	}

	public long getClassnum() {
		return this.classnum;
	}

	public void setClassnum(long classnum) {
		this.classnum = classnum;
	}

	public String getCrn() {
		return this.crn;
	}

	public void setCrn(String crn) {
		this.crn = crn;
	}

	public BigDecimal getEnrollmenthold() {
		return this.enrollmenthold;
	}

	public void setEnrollmenthold(BigDecimal enrollmenthold) {
		this.enrollmenthold = enrollmenthold;
	}

	public Hclassroom getHclassroom() {
		return this.hclassroom;
	}

	public void setHclassroom(Hclassroom hclassroom) {
		this.hclassroom = hclassroom;
	}

	public Hcourse getHcourse() {
		return this.hcourse;
	}

	public void setHcourse(Hcourse hcourse) {
		this.hcourse = hcourse;
	}

	public Hinstructor getHinstructor() {
		return this.hinstructor;
	}

	public void setHinstructor(Hinstructor hinstructor) {
		this.hinstructor = hinstructor;
	}

	public Hschedule getHschedule() {
		return this.hschedule;
	}

	public void setHschedule(Hschedule hschedule) {
		this.hschedule = hschedule;
	}

	public Hsemester getHsemester() {
		return this.hsemester;
	}

	public void setHsemester(Hsemester hsemester) {
		this.hsemester = hsemester;
	}

	public List<Henrollment> getHenrollments() {
		return this.henrollments;
	}

	public void setHenrollments(List<Henrollment> henrollments) {
		this.henrollments = henrollments;
	}

	public Henrollment addHenrollment(Henrollment henrollment) {
		getHenrollments().add(henrollment);
		henrollment.setHclass(this);

		return henrollment;
	}

	public Henrollment removeHenrollment(Henrollment henrollment) {
		getHenrollments().remove(henrollment);
		henrollment.setHclass(null);

		return henrollment;
	}

}