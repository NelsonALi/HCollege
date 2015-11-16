package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the ENROLL_STATUS database table.
 * 
 */
@Entity
@Table(name="ENROLL_STATUS", schema="TESTUSERDB")
@NamedQuery(name="EnrollStatus.findAll", query="SELECT e FROM EnrollStatus e")
public class EnrollStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	 @Id
	 @SequenceGenerator( name = "ENROLL_STATUS_SEQ", sequenceName = "ENROLL_STATUS_SEQ", allocationSize = 1, initialValue = 1 )
	 @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "ENROLL_STATUS_SEQ" )
	private long id;

	private String status;

	//bi-directional many-to-one association to Enrollment
	@OneToMany(mappedBy="enrollStatus")
	private List<Enrollment> enrollments;

	public EnrollStatus() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Enrollment> getEnrollments() {
		return this.enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public Enrollment addEnrollment(Enrollment enrollment) {
		getEnrollments().add(enrollment);
		enrollment.setEnrollStatus(this);

		return enrollment;
	}

	public Enrollment removeEnrollment(Enrollment enrollment) {
		getEnrollments().remove(enrollment);
		enrollment.setEnrollStatus(null);

		return enrollment;
	}

}