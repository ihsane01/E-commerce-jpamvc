package ma.fstt.persistance.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ma.fstt.persistance.model.Produit;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("unit");
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				
				em.getTransaction().commit();

	}

}
