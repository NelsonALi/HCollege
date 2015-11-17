package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HMAJOR database table.
 * 
 */
@Entity
@NamedQuery(name="Hmajor.findAll", query="SELECT h FROM Hmajor h")
public class Hmajor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HMAJOR_MAJORCODE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HMAJOR_MAJORCODE_GENERATOR")
	private long majorcode;

	private String majorname;

	private BigDecimal statuscode;

	//bi-directional many-to-one association to Hdepartment
	@ManyToOne
	@JoinColumn(name="DEPARTCODE")
	private Hdepartment hdepartment;

	//bi-directional many-to-one association to Hstudent
	@OneToMany(mappedBy="hmajor")
	private List<Hstudent> hstudents;

	public Hmajor() {
	}

	public long getMajorcode() {
		return this.majorcode;
	}

	public void setMajorcode(long majorcode) {
		this.majorcode = majorcode;
	}

	public String getMajorname() {
		return this.majorname;
	}

	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}

	public BigDecimal getStatuscode() {
		return this.statuscode;
	}

	public void setStatuscode(BigDecimal statuscode) {
		this.statuscode = statuscode;
	}

	public Hdepartment getHdepartment() {
		return this.hdepartment;
	}

	public void setHdepartment(Hdepartment hdepartment) {
		this.hdepartment = hdepartment;
	}

	public List<Hstudent> getHstudents() {
		return this.hstudents;
	}

	public void setHstudents(List<Hstudent> hstudents) {
		this.hstudents = hstudents;
	}

	public Hstudent addHstudent(Hstudent hstudent) {
		getHstudents().add(hstudent);
		hstudent.setHmajor(this);

		return hstudent;
	}

	public Hstudent removeHstudent(Hstudent hstudent) {
		getHstudents().remove(hstudent);
		hstudent.setHmajor(null);

		return hstudent;
	}

}