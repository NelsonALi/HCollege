package customTools;

	import java.util.ArrayList;
	import java.util.List;
	import javax.persistence.EntityManager;
	import javax.persistence.EntityTransaction;
	import javax.persistence.NoResultException;
	import javax.persistence.TypedQuery;
	import model.Hclass;

	public class ClassesDB {
		public static void insert(Hclass aClass) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			try {
				em.persist(aClass);
				trans.commit();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}
		}

		public static void update(Hclass aClass) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			try {
				em.merge(aClass);
				trans.commit();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}
		}

		public static void delete(Hclass aClass) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			try {
				em.remove(em.merge(aClass));
				trans.commit();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}
		}

		public static ArrayList<Hclass> selectAll() {
			List<Hclass> pList = null;
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "select e from Hclass e";
			TypedQuery<Hclass> q = (TypedQuery<Hclass>) em.createQuery(qString, Hclass.class);
			try {
				pList = q.getResultList();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				em.close();
			}
			return  new ArrayList<Hclass>( pList);
		}

		public static ArrayList<Hclass> classesBySuject(String subjectCode) {
			List<Hclass> cList = null;
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "select e from Hclass e where e.hcourse.subjectcode='" + subjectCode + "'";
			TypedQuery<Hclass> q = (TypedQuery<Hclass>) em.createQuery(qString, Hclass.class);
//			TypedQuery<Long> query = em.createQuery("SELECT COUNT(c) FROM DemoCustomer c WHERE c.customerId = 2L", Long.class);
			try {
				cList = q.getResultList();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				em.close();
			}
			return  new ArrayList<Hclass>(cList);
		}	 

		public static ArrayList<Hclass> classesByDept(String departName) {
			List<Hclass> cList = null;
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "select e from Hclass e where e.hcourse.hdepartment.departname='" + departName + "'";
			TypedQuery<Hclass> q = (TypedQuery<Hclass>) em.createQuery(qString, Hclass.class);
			try {
				cList = q.getResultList();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				em.close();
			}
			return  new ArrayList<Hclass>(cList);
		}	

		public static ArrayList<Hclass> classesByInstructor(String instructorName) {
			List<Hclass> cList = null;
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "select e from Hclass e where e.hinstructor.instructorname='" + instructorName + "'";
			TypedQuery<Hclass> q = (TypedQuery<Hclass>) em.createQuery(qString, Hclass.class);
			try {
				cList = q.getResultList();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				em.close();
			}
			return  new ArrayList<Hclass>(cList);
		}	

		public static ArrayList<Hclass> classesByTime(String classTime) {
			List<Hclass> cList = null;
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "select e from Hclass e where e.hschedule.dow1 like '%" +classTime + "%' or e.hschedule.ampm like '%" + classTime + "%'";
			TypedQuery<Hclass> q = (TypedQuery<Hclass>) em.createQuery(qString, Hclass.class);
			try {
				cList = q.getResultList();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				em.close();
			}
			return  new ArrayList<Hclass>(cList);
		}	
	}
