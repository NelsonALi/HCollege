package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HINSTRUCTOR database table.
 * 
 */
@Entity
@NamedQuery(name="Hinstructor.findAll", query="SELECT h FROM Hinstructor h")
public class Hinstructor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HINSTRUCTOR_INSTRUCTORNUM_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HINSTRUCTOR_INSTRUCTORNUM_GENERATOR")
	private long instructornum;

	private String instructorname;

	private String netid;

	private String officelocation;

	//bi-directional many-to-one association to Hclass
	@OneToMany(mappedBy="hinstructor")
	private List<Hclass> hclasses;

	//bi-directional many-to-one association to Hdepartment
	@ManyToOne
	@JoinColumn(name="DEPARTCODE")
	private Hdepartment hdepartment;

	public Hinstructor() {
	}

	public long getInstructornum() {
		return this.instructornum;
	}

	public void setInstructornum(long instructornum) {
		this.instructornum = instructornum;
	}

	public String getInstructorname() {
		return this.instructorname;
	}

	public void setInstructorname(String instructorname) {
		this.instructorname = instructorname;
	}

	public String getNetid() {
		return this.netid;
	}

	public void setNetid(String netid) {
		this.netid = netid;
	}

	public String getOfficelocation() {
		return this.officelocation;
	}

	public void setOfficelocation(String officelocation) {
		this.officelocation = officelocation;
	}

	public List<Hclass> getHclasses() {
		return this.hclasses;
	}

	public void setHclasses(List<Hclass> hclasses) {
		this.hclasses = hclasses;
	}

	public Hclass addHclass(Hclass hclass) {
		getHclasses().add(hclass);
		hclass.setHinstructor(this);

		return hclass;
	}

	public Hclass removeHclass(Hclass hclass) {
		getHclasses().remove(hclass);
		hclass.setHinstructor(null);

		return hclass;
	}

	public Hdepartment getHdepartment() {
		return this.hdepartment;
	}

	public void setHdepartment(Hdepartment hdepartment) {
		this.hdepartment = hdepartment;
	}

}