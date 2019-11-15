package sopra.formation.repository.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sopra.formation.model.Evaluation;
import sopra.formation.repository.IEvaluationRepository;

@Repository
@Transactional
public class EvaluationRepositoryJpa implements IEvaluationRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Evaluation> findAll() {
		TypedQuery<Evaluation> query = em.createQuery("from Evaluation", Evaluation.class);

		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Evaluation find(Long id) {
		return em.find(Evaluation.class, id);
	}

	@Override
	public Evaluation save(Evaluation obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Evaluation obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional(readOnly = true)
	public List<Evaluation> findAllByComportementale(Integer comportementale) {
		TypedQuery<Evaluation> query = em.createQuery("from Evaluation e where e.comportementale = :note",
				Evaluation.class);

		query.setParameter("note", comportementale);

		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Evaluation findByStagiaire(String nom, String prenom) {
		TypedQuery<Evaluation> query = em.createQuery(
				"from Evaluation e where e.stagiaire.nom = :nom and e.stagiaire.prenom = :prenom", Evaluation.class);

		query.setParameter("nom", nom);
		query.setParameter("prenom", prenom);

		return query.getSingleResult();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Evaluation> findAllByDtNaissance(Date dtNaissance) {
		TypedQuery<Evaluation> query = em.createQuery(
				"select e from Evaluation e join fetch e.stagiaire s where s.dtNaissance > :dtNais", Evaluation.class);

		query.setParameter("dtNais", dtNaissance);

		return query.getResultList();
	}

}
