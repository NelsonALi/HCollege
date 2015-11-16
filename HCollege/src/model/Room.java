package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ROOM database table.
 * 
 */
@Entity
@Table(name="ROOM", schema="TESTUSERDB")
@NamedQuery(name="Room.findAll", query="SELECT r FROM Room r")
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	 @Id
	 @SequenceGenerator( name = "ROOM_SEQ", sequenceName = "ROOM_SEQ", allocationSize = 1, initialValue = 1 )
	 @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "ROOM_SEQ" )
	private long id;

	@Column(name="BLDG_NAME")
	private String bldgName;

	@Column(name="MAX_CAPACITY")
	private BigDecimal maxCapacity;

	@Column(name="ROOM_NO")
	private String roomNo;

	//bi-directional many-to-one association to Class
	@OneToMany(mappedBy="room")
	private List<Class> clazzs;

	public Room() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBldgName() {
		return this.bldgName;
	}

	public void setBldgName(String bldgName) {
		this.bldgName = bldgName;
	}

	public BigDecimal getMaxCapacity() {
		return this.maxCapacity;
	}

	public void setMaxCapacity(BigDecimal maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public String getRoomNo() {
		return this.roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public List<Class> getClazzs() {
		return this.clazzs;
	}

	public void setClazzs(List<Class> clazzs) {
		this.clazzs = clazzs;
	}

	public Class addClazz(Class clazz) {
		getClazzs().add(clazz);
		clazz.setRoom(this);

		return clazz;
	}

	public Class removeClazz(Class clazz) {
		getClazzs().remove(clazz);
		clazz.setRoom(null);

		return clazz;
	}

}