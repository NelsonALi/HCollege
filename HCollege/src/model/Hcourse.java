package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HCOURSE database table.
 * 
 */
@Entity
@NamedQuery(name="Hcourse.findAll", query="SELECT h FROM Hcourse h")
public class Hcourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HCOURSE_COURSECODE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HCOURSE_COURSECODE_GENERATOR")
	private long coursecode;

	private String coursename;

	private BigDecimal credits;

	private String description;

	private BigDecimal statuscode;

	private String subjectcode;

	//bi-directional many-to-one association to Hclass
	@OneToMany(mappedBy="hcourse")
	private List<Hclass> hclasses;

	//bi-directional many-to-one association to Hdepartment
	@ManyToOne
	@JoinColumn(name="DEPARTCODE")
	private Hdepartment hdepartment;

	public Hcourse() {
	}

	public long getCoursecode() {
		return this.coursecode;
	}

	public void setCoursecode(long coursecode) {
		this.coursecode = coursecode;
	}

	public String getCoursename() {
		return this.coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public BigDecimal getCredits() {
		return this.credits;
	}

	public void setCredits(BigDecimal credits) {
		this.credits = credits;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getStatuscode() {
		return this.statuscode;
	}

	public void setStatuscode(BigDecimal statuscode) {
		this.statuscode = statuscode;
	}

	public String getSubjectcode() {
		return this.subjectcode;
	}

	public void setSubjectcode(String subjectcode) {
		this.subjectcode = subjectcode;
	}

	public List<Hclass> getHclasses() {
		return this.hclasses;
	}

	public void setHclasses(List<Hclass> hclasses) {
		this.hclasses = hclasses;
	}

	public Hclass addHclass(Hclass hclass) {
		getHclasses().add(hclass);
		hclass.setHcourse(this);

		return hclass;
	}

	public Hclass removeHclass(Hclass hclass) {
		getHclasses().remove(hclass);
		hclass.setHcourse(null);

		return hclass;
	}

	public Hdepartment getHdepartment() {
		return this.hdepartment;
	}

	public void setHdepartment(Hdepartment hdepartment) {
		this.hdepartment = hdepartment;
	}

}