package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HDEPARTMENT database table.
 * 
 */
@Entity
@NamedQuery(name="Hdepartment.findAll", query="SELECT h FROM Hdepartment h")
public class Hdepartment implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	 @SequenceGenerator( name = "HDEPARTMENT_SEQ", sequenceName = "HDEPARTMENT_SEQ", allocationSize = 1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HDEPARTMENT_SEQ")
	private long code;

	private String departname;

	private BigDecimal statuscode;

	//bi-directional many-to-one association to Hcourse
	@OneToMany(mappedBy="hdepartment")
	private List<Hcourse> hcourses;

	//bi-directional many-to-one association to Hinstructor
	@OneToMany(mappedBy="hdepartment")
	private List<Hinstructor> hinstructors;

	//bi-directional many-to-one association to Hmajor
	@OneToMany(mappedBy="hdepartment")
	private List<Hmajor> hmajors;

	public Hdepartment() {
	}

	public long getCode() {
		return this.code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getDepartname() {
		return this.departname;
	}

	public void setDepartname(String departname) {
		this.departname = departname;
	}

	public BigDecimal getStatuscode() {
		return this.statuscode;
	}

	public void setStatuscode(BigDecimal statuscode) {
		this.statuscode = statuscode;
	}

	public List<Hcourse> getHcourses() {
		return this.hcourses;
	}

	public void setHcourses(List<Hcourse> hcourses) {
		this.hcourses = hcourses;
	}

	public Hcourse addHcours(Hcourse hcours) {
		getHcourses().add(hcours);
		hcours.setHdepartment(this);

		return hcours;
	}

	public Hcourse removeHcours(Hcourse hcours) {
		getHcourses().remove(hcours);
		hcours.setHdepartment(null);

		return hcours;
	}

	public List<Hinstructor> getHinstructors() {
		return this.hinstructors;
	}

	public void setHinstructors(List<Hinstructor> hinstructors) {
		this.hinstructors = hinstructors;
	}

	public Hinstructor addHinstructor(Hinstructor hinstructor) {
		getHinstructors().add(hinstructor);
		hinstructor.setHdepartment(this);

		return hinstructor;
	}

	public Hinstructor removeHinstructor(Hinstructor hinstructor) {
		getHinstructors().remove(hinstructor);
		hinstructor.setHdepartment(null);

		return hinstructor;
	}

	public List<Hmajor> getHmajors() {
		return this.hmajors;
	}

	public void setHmajors(List<Hmajor> hmajors) {
		this.hmajors = hmajors;
	}

	public Hmajor addHmajor(Hmajor hmajor) {
		getHmajors().add(hmajor);
		hmajor.setHdepartment(this);

		return hmajor;
	}

	public Hmajor removeHmajor(Hmajor hmajor) {
		getHmajors().remove(hmajor);
		hmajor.setHdepartment(null);

		return hmajor;
	}

}