package sopra.formation.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sopra.formation.model.Formateur;
import sopra.formation.model.Personne;
import sopra.formation.model.Stagiaire;
import sopra.formation.repository.IPersonneRepository;

@Repository
@Transactional
public class PersonneRepositoryJpa implements IPersonneRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Personne> findAll() {
		TypedQuery<Personne> query = em.createQuery("from Personne", Personne.class);

		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Personne find(Long id) {
		return em.find(Personne.class, id);
	}

	@Override
	public Personne save(Personne obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Personne obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional(readOnly = true)
	public List<Stagiaire> findAllStagiaire() {
		TypedQuery<Stagiaire> query = em.createQuery("from Stagiaire", Stagiaire.class);

		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Formateur> findAllFormateur() {
		TypedQuery<Formateur> query = em.createQuery("from Formateur", Formateur.class);

		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public <T> List<T> findAll(Class<T> clazz) {
		TypedQuery<T> query = em.createQuery("from " + clazz.getSimpleName(), clazz);

		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Stagiaire findWithEvaluation(Long id) {
		TypedQuery<Stagiaire> query = em.createQuery(
				"select distinct s from Stagiaire s join fetch s.evaluation e where s.id = :id", Stagiaire.class);

		query.setParameter("id", id);

		return query.getSingleResult();
	}

}
