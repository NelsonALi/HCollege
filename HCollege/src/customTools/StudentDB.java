package customTools;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.Hstudent;
import model.Hclass;
import model.Henrollment;

public class StudentDB {
		public static void insert(Hstudent aStudent) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			try {
				em.persist(aStudent);
				trans.commit();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}
		}

		public static void update(Hstudent aStudent) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			try {
				em.merge(aStudent);
				trans.commit();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}
		}

		public static void delete(Hstudent aStudent) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			try {
				em.remove(em.merge(aStudent));
				trans.commit();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}
		}

		public static ArrayList<Hstudent> selectAll() {
			List<Hstudent> pList = null;
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "select e from Hstudent e";
			TypedQuery<Hstudent> q = (TypedQuery<Hstudent>) em.createQuery(qString, Hstudent.class);
			try {
				pList = q.getResultList();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				em.close();
			}
			return  new ArrayList<Hstudent>( pList);
		}

		public static ArrayList<Hstudent> majorByDept(String departName) {
			List<Hstudent> cList = null;
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "select e from Hstudent e where e.hdepartment.departname='" + departName + "'";
			TypedQuery<Hstudent> q = (TypedQuery<Hstudent>) em.createQuery(qString, Hstudent.class);
			try {
				cList = q.getResultList();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				em.close();
			}
			return  new ArrayList<Hstudent>(cList);
		}	

}
