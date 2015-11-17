package customTools;
	import java.util.ArrayList;
	import java.util.List;
	import javax.persistence.EntityManager;
	import javax.persistence.EntityTransaction;
	import javax.persistence.NoResultException;
	import javax.persistence.TypedQuery;
	import model.Course;

	public class CourseDB {
		public static void insert(Course aCourse) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			try {
				em.persist(aCourse);
				trans.commit();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}
		}

		public static void update(Course aCourse) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			try {
				em.merge(aCourse);
				trans.commit();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}
		}

		public static void delete(Course aCourse) {
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			trans.begin();
			try {
				em.remove(em.merge(aCourse));
				trans.commit();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}
		}

		public static ArrayList<Course> selectAll() {
			List<Course> pList = null;
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "select e from Course e";
			TypedQuery<Course> q = (TypedQuery<Course>) em.createQuery(qString, Course.class);
			try {
				pList = q.getResultList();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				em.close();
			}
			return  new ArrayList<Course>( pList);
		}

		public static ArrayList<Course> courseBySuject(String subject) {
			List<Course> cList = null;
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			String qString = "select e from Product e where e.Subject_Code=" + subject;
			TypedQuery<Course> q = (TypedQuery<Course>) em.createQuery(qString, Course.class);
//			TypedQuery<Long> query = em.createQuery("SELECT COUNT(c) FROM DemoCustomer c WHERE c.customerId = 2L", Long.class);
			try {
				cList = q.getResultList();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				em.close();
			}
			return  new ArrayList<Course>(cList);
		}	 
/*		DB design missing Dept_Id FK
		public static ArrayList<Course> courseByDept(String Dept) {
			List<Course> cList = null;
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			String qString = "select e from Product e where e.Dept_Id=" + Dept;
			TypedQuery<Course> q = (TypedQuery<Course>) em.createQuery(qString, Course.class);
//			TypedQuery<Long> query = em.createQuery("SELECT COUNT(c) FROM DemoCustomer c WHERE c.customerId = 2L", Long.class);
			try {
				cList = q.getResultList();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				em.close();
			}
			return  new ArrayList<Course>(cList);
		}	 */
}
