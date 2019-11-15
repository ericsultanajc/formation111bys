package sopra.formation.repository;

import java.util.List;

import sopra.formation.model.Formateur;
import sopra.formation.model.Personne;
import sopra.formation.model.Stagiaire;

public interface IPersonneRepository extends IRepository<Personne, Long> {
	List<Stagiaire> findAllStagiaire();

	List<Formateur> findAllFormateur();

	<T> List<T> findAll(Class<T> clazz);

	Stagiaire findWithEvaluation(Long id);
}
