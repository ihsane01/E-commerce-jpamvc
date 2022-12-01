package ma.fstt.persistance.manager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ma.fstt.persistance.model.Panier;
import ma.fstt.persistance.model.Produit;
import ma.fstt.persistance.model.User;

public class DBPanier {
	 public static void insert(Panier panier) {
	      EntityManager em = DBUtil.getEmFactory().createEntityManager();
	      EntityTransaction transaction = em.getTransaction();
	      
	      try {
	         transaction.begin();
	         em.persist(panier);
	         transaction.commit();
	      } catch (Exception e) {
	         System.err.println(e);
	         transaction.rollback();
	      } finally {
	         em.close();
	      }
	   }
	 
	 
	 public static void delete(int id) {
		 EntityManager em = DBUtil.getEmFactory().createEntityManager();
	      EntityTransaction transaction = em.getTransaction();

	      String queryString = "SELECT p FROM panier p "
	                         + "WHERE p.id = :id";
	      TypedQuery<Panier> query = em.createQuery(queryString, Panier.class);
	      query.setParameter("id", id);
	      
	      Panier panier = null;
	      try {
	         panier = query.getSingleResult();
	         transaction.begin();
	         em.remove(panier);
	         transaction.commit();
	         
	      } catch (Exception e) {
	         System.err.println(e);
	      } finally {
	         em.close();
	      }
	      
	   }
	 public static Panier selectPanier(int id ) {
	      EntityManager em = DBUtil.getEmFactory().createEntityManager();
	      String queryString = "SELECT p FROM panier p "
	                         + "WHERE p.id = :id";
	      TypedQuery<Panier> query = em.createQuery(queryString, Panier.class);
	      query.setParameter("id", id);
	      
	      Panier panier = null;
	      try {
	         panier = query.getSingleResult();
	      } catch (Exception e) {
	         System.err.println(e);
	      } finally {
	         em.close();
	      }
	      
	      return panier;
	   }
	 
	 
	 public static List<Panier> selectPaniers(User user) {
	      EntityManager em = DBUtil.getEmFactory().createEntityManager();
	      String queryString = "SELECT p FROM Panier p "
	    		  + "WHERE p.iduser = :id";
	      Query query = em.createQuery(queryString);
	      query.setParameter("id", user.getId());

	      List<Panier> paniers = null;
	      
	      try {
	         paniers = query.getResultList();
	      } catch (Exception e) {
	         System.err.println(e);
	      } finally {
	         em.close();
	      }
	      
	      return paniers;
	   }
}
