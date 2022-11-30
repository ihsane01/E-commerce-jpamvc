package ma.fstt.persistance.manager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
	  private static final EntityManagerFactory emf = 
	           Persistence.createEntityManagerFactory("unit");
	   
	   public static EntityManagerFactory getEmFactory() {
	      return emf;
}}
