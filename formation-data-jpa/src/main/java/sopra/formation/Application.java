package sopra.formation;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sopra.formation.repository.IEvaluationRepository;
import sopra.formation.repository.IFiliereRepository;
import sopra.formation.repository.IMatiereRepository;
import sopra.formation.repository.IModuleRepository;
import sopra.formation.repository.IPersonneRepository;
import sopra.formation.repository.ISalleRepository;
import sopra.formation.repository.jpa.EvaluationRepositoryJpa;
import sopra.formation.repository.jpa.FiliereRepositoryJpa;
import sopra.formation.repository.jpa.MatiereRepositoryJpa;
import sopra.formation.repository.jpa.ModuleRepositoryJpa;
import sopra.formation.repository.jpa.PersonneRepositoryJpa;
import sopra.formation.repository.jpa.SalleRepositoryJpa;

public class Application {
	private static Application instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation-tp");

	private final IEvaluationRepository evaluationRepo = new EvaluationRepositoryJpa();
	private final IFiliereRepository filiereRepo = new FiliereRepositoryJpa();
	private final IMatiereRepository matiereRepo = new MatiereRepositoryJpa();
	private final IModuleRepository moduleRepo = new ModuleRepositoryJpa();
	private final IPersonneRepository personneRepo = new PersonneRepositoryJpa();
	private final ISalleRepository salleRepo = new SalleRepositoryJpa();

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

	public IFiliereRepository getFiliereRepo() {
		return filiereRepo;
	}

	public IMatiereRepository getMatiereRepo() {
		return matiereRepo;
	}

	public IModuleRepository getModuleRepo() {
		return moduleRepo;
	}

	public IPersonneRepository getPersonneRepo() {
		return personneRepo;
	}

	public ISalleRepository getSalleRepo() {
		return salleRepo;
	}

}
