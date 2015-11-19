package customTools;

	import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Huser;

	public class UserDB {
		public static void insert(Huser anUser) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			try {
				em.persist(anUser);
				trans.commit();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}
		}

		public static void update(Huser anUser) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			try {
				em.merge(anUser);
				trans.commit();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}
		}

		public static void delete(Huser anUser) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			try {
				em.remove(em.merge(anUser));
				trans.commit();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}
		}

		public static ArrayList<Huser> selectAll() {
			List<Huser> pList = null;
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "select e from Huser e";
			TypedQuery<Huser> q = (TypedQuery<Huser>) em.createQuery(qString, Huser.class);
			try {
				pList = q.getResultList();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				em.close();
			}
			return  new ArrayList<Huser>( pList);
		}
		public static boolean isAdmin(String loginName) {
			boolean admin = false;
			Huser huser = getHuserByName(loginName);
/*			if (huser != null) {
				if(huser.getAdminrole().intValue()>0) admin = true;
			}
*/			return admin ;
		}
		public static boolean huserExist(String loginName) {
			boolean exist = false;
			Huser todoer = getHuserByName(loginName);
			if (todoer != null) exist = true;
			return exist ;
		}
		public static Huser getHuserByName(String loginName) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "select e from Huser e where e.netid = :loginName";
			TypedQuery<Huser> q = (TypedQuery<Huser>) em.createQuery(qString, Huser.class);
			q.setParameter("loginName", loginName);
			Huser todoer = null;
			try {
				todoer = q.getSingleResult();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				em.close();
			}
			return todoer ;
		}
	}
