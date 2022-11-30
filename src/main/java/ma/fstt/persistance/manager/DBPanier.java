package ma.fstt.persistance.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import ma.fstt.persistance.model.Panier;
import ma.fstt.persistance.model.Produit;

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

	      String queryString = "SELECT p FROM Produit p "
	                         + "WHERE p.id = :id";
	      TypedQuery<Produit> query = em.createQuery(queryString, Produit.class);
	      query.setParameter("id", id);
	      
	      Produit product = null;
	      try {
	         product = query.getSingleResult();
	         transaction.begin();
	         em.remove(product);
	         transaction.commit();
	         
	      } catch (Exception e) {
	         System.err.println(e);
	      } finally {
	         em.close();
	      }
	      
	   }
}
