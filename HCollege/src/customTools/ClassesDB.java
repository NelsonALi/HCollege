package customTools;

	import java.util.ArrayList;
	import java.util.List;
	import javax.persistence.EntityManager;
	import javax.persistence.EntityTransaction;
	import javax.persistence.NoResultException;
	import javax.persistence.TypedQuery;
	import model.Classes;

	public class ClassesDB {
		public static void insert(Classes aClass) {
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

		public static void update(Classes aClass) {
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

		public static void delete(Classes aClass) {
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

		public static ArrayList<Classes> selectAll() {
			List<Classes> pList = null;
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "select e from Classes e";
			TypedQuery<Classes> q = (TypedQuery<Classes>) em.createQuery(qString, Classes.class);
			try {
				pList = q.getResultList();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				em.close();
			}
			return  new ArrayList<Classes>( pList);
		}

		public static ArrayList<Classes> courseBySuject(String subjectCode) {
			List<Classes> cList = null;
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "select e from Product e where e.course.subjectCode=" + subjectCode;
			TypedQuery<Classes> q = (TypedQuery<Classes>) em.createQuery(qString, Classes.class);
//			TypedQuery<Long> query = em.createQuery("SELECT COUNT(c) FROM DemoCustomer c WHERE c.customerId = 2L", Long.class);
			try {
				cList = q.getResultList();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				em.close();
			}
			return  new ArrayList<Classes>(cList);
		}	 
/*		DB design missing Dept_Id FK
		public static ArrayList<Class> courseByDept(String Dept) {
			List<Class> cList = null;
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			String qString = "select e from Product e where e.Dept_Id=" + Dept;
			TypedQuery<Class> q = (TypedQuery<Class>) em.createQuery(qString, Class.class);
//			TypedQuery<Long> query = em.createQuery("SELECT COUNT(c) FROM DemoCustomer c WHERE c.customerId = 2L", Long.class);
			try {
				cList = q.getResultList();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				em.close();
			}
			return  new ArrayList<Class>(cList);
		}	 */
}
