package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HENROLLMENT database table.
 * 
 */
@Entity
@NamedQuery(name="Henrollment.findAll", query="SELECT h FROM Henrollment h")
public class Henrollment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HENROLLMENT_ENROLLMENTNUM_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HENROLLMENT_ENROLLMENTNUM_GENERATOR")
	private long enrollmentnum;

	private String grade;

	//bi-directional many-to-one association to Hclass
	@ManyToOne
	@JoinColumn(name="CLASSNUM")
	private Hclass hclass;

	//bi-directional many-to-one association to Hstudent
	@ManyToOne
	@JoinColumn(name="STUDENTNUM")
	private Hstudent hstudent;

	public Henrollment() {
	}

	public long getEnrollmentnum() {
		return this.enrollmentnum;
	}

	public void setEnrollmentnum(long enrollmentnum) {
		this.enrollmentnum = enrollmentnum;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Hclass getHclass() {
		return this.hclass;
	}

	public void setHclass(Hclass hclass) {
		this.hclass = hclass;
	}

	public Hstudent getHstudent() {
		return this.hstudent;
	}

	public void setHstudent(Hstudent hstudent) {
		this.hstudent = hstudent;
	}

}