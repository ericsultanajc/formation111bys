package sopra.formation.repository;

import java.util.List;

import sopra.formation.model.Evaluation;

public interface IEvaluationRepository extends IRepository<Evaluation, Long> {
	List<Evaluation> findAllByComportementale(Integer comportementale);
	
	Evaluation findByStagiaire(String nom, String prenom);
}
