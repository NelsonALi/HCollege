package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HSCHEDULE database table.
 * 
 */
@Entity
@NamedQuery(name="Hschedule.findAll", query="SELECT h FROM Hschedule h")
public class Hschedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HSCHEDULE_SCHEDULECODE_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HSCHEDULE_SCHEDULECODE_GENERATOR")
	private long schedulecode;

	private String ampm;

	private String dow1;

	private String dow2;

	private BigDecimal hour12;

	private BigDecimal minutes60;

	//bi-directional many-to-one association to Hclass
	@OneToMany(mappedBy="hschedule")
	private List<Hclass> hclasses;

	public Hschedule() {
	}

	public long getSchedulecode() {
		return this.schedulecode;
	}

	public void setSchedulecode(long schedulecode) {
		this.schedulecode = schedulecode;
	}

	public String getAmpm() {
		return this.ampm;
	}

	public void setAmpm(String ampm) {
		this.ampm = ampm;
	}

	public String getDow1() {
		return this.dow1;
	}

	public void setDow1(String dow1) {
		this.dow1 = dow1;
	}

	public String getDow2() {
		return this.dow2;
	}

	public void setDow2(String dow2) {
		this.dow2 = dow2;
	}

	public BigDecimal getHour12() {
		return this.hour12;
	}

	public void setHour12(BigDecimal hour12) {
		this.hour12 = hour12;
	}

	public BigDecimal getMinutes60() {
		return this.minutes60;
	}

	public void setMinutes60(BigDecimal minutes60) {
		this.minutes60 = minutes60;
	}

	public List<Hclass> getHclasses() {
		return this.hclasses;
	}

	public void setHclasses(List<Hclass> hclasses) {
		this.hclasses = hclasses;
	}

	public Hclass addHclass(Hclass hclass) {
		getHclasses().add(hclass);
		hclass.setHschedule(this);

		return hclass;
	}

	public Hclass removeHclass(Hclass hclass) {
		getHclasses().remove(hclass);
		hclass.setHschedule(null);

		return hclass;
	}

}