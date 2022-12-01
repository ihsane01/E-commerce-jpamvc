package ma.fstt.persistance.manager;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ma.fstt.persistance.model.Produit;


public class DBProduit {
	 public static void insert(Produit product) {
	      EntityManager em = DBUtil.getEmFactory().createEntityManager();
	      EntityTransaction transaction = em.getTransaction();
	      
	      try {
	         transaction.begin();
	         em.persist(product);
	         transaction.commit();
	      } catch (Exception e) {
	         System.err.println(e);
	         transaction.rollback();
	      } finally {
	         em.close();
	      }
	   }
	 
	 
	 public static void delete(Long id) {
		 EntityManager em = DBUtil.getEmFactory().createEntityManager();
	      EntityTransaction transaction = em.getTransaction();

	      String queryString = "SELECT p FROM Produit p "
	                         + "WHERE p.Id = :id";
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
	 
	 public static void update(Produit pro) {
	      EntityManager em = DBUtil.getEmFactory().createEntityManager();
	      EntityTransaction transaction = em.getTransaction();

	      try {
	         transaction.begin();
	         em.merge(pro);
	         transaction.commit();
	      } catch (Exception e) {
	         System.out.println(e);
	         transaction.rollback();
	      } finally {
	         em.close();
	      }
	   }
	 
	 public static List<Produit> selectProducts() {
	      EntityManager em = DBUtil.getEmFactory().createEntityManager();
	      String queryString = "SELECT p FROM Produit p";
	      Query query = em.createQuery(queryString);
	      
	      List<Produit> products = null;
	      
	      try {
	         products = query.getResultList();
	      } catch (Exception e) {
	         System.err.println(e);
	         System.out.println("hii");
	      } finally {
	         em.close();
	      }
	      
	      return products;
	   }
	 public static Produit selectProduct(int productCode) {
	      EntityManager em = DBUtil.getEmFactory().createEntityManager();
	      String queryString = "SELECT p FROM Produit p "
	                         + "WHERE p.Id = :code";
	      TypedQuery<Produit> query = em.createQuery(queryString, Produit.class);
	      query.setParameter("code", productCode);
	      
	      Produit product = null;
	      try {
	         product = query.getSingleResult();
	      } catch (Exception e) {
	         System.err.println(e);
	      } finally {
	         em.close();
	      }
	      
	      return product;
	   }
	 
}
