package console;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.TVehicule;

public class services {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("my-jpa-conf");
			em = emf.createEntityManager();
			
			List<TVehicule> tvehicules = em.createQuery("From TVehicule", TVehicule.class).getResultList();
			
			for (TVehicule vehicule : tvehicules) {
				System.out.println(vehicule);
			}
					
		} finally {
			if (emf != null) emf.close();
			if (em != null) em.close();
			
		}				
	}
}