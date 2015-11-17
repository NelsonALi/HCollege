package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HCLASSROOM database table.
 * 
 */
@Entity
@NamedQuery(name="Hclassroom.findAll", query="SELECT h FROM Hclassroom h")
public class Hclassroom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HCLASSROOM_ROOMID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HCLASSROOM_ROOMID_GENERATOR")
	private long roomid;

	private String bldgname;

	private BigDecimal maxcapacity;

	private String roomnumber;

	private BigDecimal statuscode;

	//bi-directional many-to-one association to Hclass
	@OneToMany(mappedBy="hclassroom")
	private List<Hclass> hclasses;

	public Hclassroom() {
	}

	public long getRoomid() {
		return this.roomid;
	}

	public void setRoomid(long roomid) {
		this.roomid = roomid;
	}

	public String getBldgname() {
		return this.bldgname;
	}

	public void setBldgname(String bldgname) {
		this.bldgname = bldgname;
	}

	public BigDecimal getMaxcapacity() {
		return this.maxcapacity;
	}

	public void setMaxcapacity(BigDecimal maxcapacity) {
		this.maxcapacity = maxcapacity;
	}

	public String getRoomnumber() {
		return this.roomnumber;
	}

	public void setRoomnumber(String roomnumber) {
		this.roomnumber = roomnumber;
	}

	public BigDecimal getStatuscode() {
		return this.statuscode;
	}

	public void setStatuscode(BigDecimal statuscode) {
		this.statuscode = statuscode;
	}

	public List<Hclass> getHclasses() {
		return this.hclasses;
	}

	public void setHclasses(List<Hclass> hclasses) {
		this.hclasses = hclasses;
	}

	public Hclass addHclass(Hclass hclass) {
		getHclasses().add(hclass);
		hclass.setHclassroom(this);

		return hclass;
	}

	public Hclass removeHclass(Hclass hclass) {
		getHclasses().remove(hclass);
		hclass.setHclassroom(null);

		return hclass;
	}

}