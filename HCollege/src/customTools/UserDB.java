package customTools;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.*;

public class UserDB {
	
	private String name;
	private String Role;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}

		public static List<Course> viewAllCourse() {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			List<Course> tList = new ArrayList<Course>();
			String qString = "select e from Course e";
			TypedQuery<Course> q = (TypedQuery<Course>) em.createQuery(qString, Course.class);
			List<Course> items = null;
			try {
				items = q.getResultList();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}
			return items;
		}
}
