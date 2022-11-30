package ma.fstt.persistance.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import ma.fstt.persistance.model.User;


public class DBUser {
	
	
	

	 public static void insert(User customer)  {
	      EntityManager em = DBUtil.getEmFactory().createEntityManager();
	      EntityTransaction transaction = em.getTransaction();

	      try {
	         transaction.begin();
	         em.persist(customer);
	         transaction.commit();
	      } catch (Exception e) {
	         System.out.println(e);
	         transaction.rollback();
	      } finally {
	         em.close();
	      }
	   }
	 
	 public static void update(User customer) {
	      EntityManager em = DBUtil.getEmFactory().createEntityManager();
	      EntityTransaction transaction = em.getTransaction();

	      try {
	         transaction.begin();
	         em.merge(customer);
	         transaction.commit();
	      } catch (Exception e) {
	         System.out.println(e);
	         transaction.rollback();
	      } finally {
	         em.close();
	      }
	   }
	 public static User selectuser(String username) {
		  EntityManager em = DBUtil.getEmFactory().createEntityManager();
	      String queryString = "SELECT u FROM User u "
					+ "where u.name='"+username+"' ";
	      TypedQuery<User> query = em.createQuery(queryString, User.class);
	      User user = null;
	      user=query.getSingleResult();
	      return user;
	 }
	 public static boolean selectuser(String email,String password) {
		 boolean authenticated=false;
	      EntityManager em = DBUtil.getEmFactory().createEntityManager();
	      String queryString = "SELECT u FROM User u "
					+ "where u.email='"+email+"' and u.password='"+password+"'";
	      TypedQuery<User> query = em.createQuery(queryString, User.class);
	      
	      User user = null;
	      try {
	         user = query.getSingleResult();
	         if(user!=null) {
	        	 if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
	        		 authenticated=true;}}
	         else {
	        	 authenticated=false;
	         }
	      } catch (Exception e) {
	         System.err.println(e);
	      } finally {
	         em.close();
	      }
	      return authenticated;
	      
	      }
	 }
	   
	   
