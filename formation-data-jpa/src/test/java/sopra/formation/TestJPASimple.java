package sopra.formation;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import sopra.formation.model.Evaluation;
import sopra.formation.model.Filiere;
import sopra.formation.model.Formateur;
import sopra.formation.model.Matiere;
import sopra.formation.model.NiveauMatiere;
import sopra.formation.model.Stagiaire;

public class TestJPASimple {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-tp");

		EntityManager em = null;
		EntityTransaction tx = null;

		Evaluation evalSylvain = null;

		Filiere sopraJavaBdx = null;

		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			evalSylvain = new Evaluation(12, 15, "pas tout le temps clair"); // new ou transient

			em.persist(evalSylvain); // managed

			evalSylvain.setCommentaires("pas tout le temps clair et ferme les yeux");

			Stagiaire sylvain = new Stagiaire("HANSMETZGER", "Sylvain");

			sylvain.setEvaluation(evalSylvain);

			em.persist(sylvain);

			sopraJavaBdx = new Filiere("SOPRA JAVA BDX", sdf.parse("23/09/2019"));

			em.persist(sopraJavaBdx);

			sylvain.setFiliere(sopraJavaBdx);

			Formateur eric = new Formateur("SULTAN", "Eric", 20);
			em.persist(eric);

			sopraJavaBdx.setReferent(eric);

			Matiere jpa = new Matiere("JPA", NiveauMatiere.MOYEN, 5);
			em.persist(jpa);

			Matiere maven = new Matiere("MAVEN", NiveauMatiere.FACILE, 1);
			em.persist(maven);

			eric.getCompetences().add(jpa);
			eric.getCompetences().add(maven);

			tx.commit(); // em.flush();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

//		#####################################

		evalSylvain.setComportementale(15); // detached

//		#####################################

		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			Evaluation evalSylvainBis = em.merge(evalSylvain); // evalSylvain:detached - evalSylvainBis:managed

			Filiere sopraJavaBdxBis = em.find(Filiere.class, sopraJavaBdx.getId());

			// em.remove(sopraJavaBdxBis); // remove
			//
			// em.flush();
			//
			// em.persist(sopraJavaBdxBis);
			
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		emf.close();
	}
}
