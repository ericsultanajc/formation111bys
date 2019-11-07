package sopra.formation;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.formation.repository.IEvaluationRepository;
import sopra.formation.repository.jpa.EvaluationRepositoryJpa;

public class Application {
	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-tp");

	private final IEvaluationRepository evaluationRepo = new EvaluationRepositoryJpa();

	private Application() {
	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public IEvaluationRepository getEvaluationRepo() {
		return evaluationRepo;
	}

}
