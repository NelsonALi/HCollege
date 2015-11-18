package customTools;

	import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Hclass;
import model.Hmajor;

	public class MajorDB {
		public static void insert(Hmajor aMajor) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			try {
				em.persist(aMajor);
				trans.commit();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}
		}

		public static void update(Hmajor aMajor) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			try {
				em.merge(aMajor);
				trans.commit();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}
		}

		public static void delete(Hmajor aMajor) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			try {
				em.remove(em.merge(aMajor));
				trans.commit();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}
		}

		public static ArrayList<Hmajor> selectAll() {
			List<Hmajor> pList = null;
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "select e from Hmajor e";
			TypedQuery<Hmajor> q = (TypedQuery<Hmajor>) em.createQuery(qString, Hmajor.class);
			try {
				pList = q.getResultList();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				em.close();
			}
			return  new ArrayList<Hmajor>( pList);
		}

		public static ArrayList<Hmajor> majorByDept(String departName) {
			List<Hmajor> cList = null;
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "select e from Hmajor e where e.hdepartment.departname='" + departName + "'";
			TypedQuery<Hmajor> q = (TypedQuery<Hmajor>) em.createQuery(qString, Hmajor.class);
			try {
				cList = q.getResultList();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				em.close();
			}
			return  new ArrayList<Hmajor>(cList);
		}	
}
