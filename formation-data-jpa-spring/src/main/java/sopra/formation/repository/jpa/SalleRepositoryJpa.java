package sopra.formation.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sopra.formation.model.Salle;
import sopra.formation.model.SalleId;
import sopra.formation.repository.ISalleRepository;

@Repository
@Transactional
public class SalleRepositoryJpa implements ISalleRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Salle> findAll() {
		TypedQuery<Salle> query = em.createQuery("from Salle", Salle.class);

		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Salle find(SalleId id) {
		return em.find(Salle.class, id);
	}

	@Override
	public Salle save(Salle obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Salle obj) {
		em.remove(em.merge(obj));
	}

}
