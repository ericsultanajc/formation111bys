package sopra.formation.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sopra.formation.model.Filiere;
import sopra.formation.repository.IFiliereRepository;

@Repository
@Transactional
public class FiliereRepositoryJpa implements IFiliereRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Filiere> findAll() {
		TypedQuery<Filiere> query = em.createQuery("from Filiere", Filiere.class);

		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Filiere find(Long id) {
		return em.find(Filiere.class, id);
	}

	@Override
	public Filiere save(Filiere obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Filiere obj) {
		em.remove(em.merge(obj));
	}

}
