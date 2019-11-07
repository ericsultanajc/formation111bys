package sopra.formation;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import sopra.formation.model.Matiere;
import sopra.formation.model.NiveauMatiere;

public class TestJPA {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-tp");

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();

//		Evaluation evalSylvain = new Evaluation(12, 15, "pas tout le temps clair");
//
//		em.persist(evalSylvain);
//
//		Stagiaire sylvain = new Stagiaire("HANSMETZGER", "Sylvain");
//		
//		sylvain.setEvaluation(evalSylvain);
//
//		em.persist(sylvain);
//		
//		Filiere sopraJavaBdx = new Filiere("SOPRA JAVA BDX", sdf.parse("23/09/2019"));
//		
//		em.persist(sopraJavaBdx);
//		
//		Formateur eric = new Formateur("SULTAN", "Eric", 20);
//		em.persist(eric);
//
//		sopraJavaBdx.setReferent(eric);
//		
//		Matiere jpa = new Matiere("JPA", NiveauMatiere.MOYEN, 5);
//		em.persist(jpa);
//		
//		Matiere maven = new Matiere("MAVEN", NiveauMatiere.FACILE, 1);
//		em.persist(maven);
//		
//		eric.getCompetences().add(jpa);
//		eric.getCompetences().add(maven);

		Matiere maven = new Matiere("MAVEN", NiveauMatiere.FACILE, 1);
		em.persist(maven);

		tx.commit();
		em.close();

		emf.close();
	}
}
