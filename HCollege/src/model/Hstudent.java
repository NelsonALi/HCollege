package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HSTUDENT database table.
 * 
 */
@Entity
@NamedQuery(name="Hstudent.findAll", query="SELECT h FROM Hstudent h")
public class Hstudent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HSTUDENT_STUDENTNUM_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HSTUDENT_STUDENTNUM_GENERATOR")
	private long studentnum;

	private String netid;

	private String studentname;

	private BigDecimal yearofentry;

	//bi-directional many-to-one association to Henrollment
	@OneToMany(mappedBy="hstudent")
	private List<Henrollment> henrollments;

	//bi-directional many-to-one association to Hmajor
	@ManyToOne
	@JoinColumn(name="MAJORCODE")
	private Hmajor hmajor;

	public Hstudent() {
	}

	public long getStudentnum() {
		return this.studentnum;
	}

	public void setStudentnum(long studentnum) {
		this.studentnum = studentnum;
	}

	public String getNetid() {
		return this.netid;
	}

	public void setNetid(String netid) {
		this.netid = netid;
	}

	public String getStudentname() {
		return this.studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public BigDecimal getYearofentry() {
		return this.yearofentry;
	}

	public void setYearofentry(BigDecimal yearofentry) {
		this.yearofentry = yearofentry;
	}

	public List<Henrollment> getHenrollments() {
		return this.henrollments;
	}

	public void setHenrollments(List<Henrollment> henrollments) {
		this.henrollments = henrollments;
	}

	public Henrollment addHenrollment(Henrollment henrollment) {
		getHenrollments().add(henrollment);
		henrollment.setHstudent(this);

		return henrollment;
	}

	public Henrollment removeHenrollment(Henrollment henrollment) {
		getHenrollments().remove(henrollment);
		henrollment.setHstudent(null);

		return henrollment;
	}

	public Hmajor getHmajor() {
		return this.hmajor;
	}

	public void setHmajor(Hmajor hmajor) {
		this.hmajor = hmajor;
	}

}