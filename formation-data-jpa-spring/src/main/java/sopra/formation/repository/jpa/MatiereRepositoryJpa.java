package sopra.formation.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sopra.formation.model.Filiere;
import sopra.formation.model.Matiere;
import sopra.formation.model.MatiereId;
import sopra.formation.repository.IMatiereRepository;

@Repository
@Transactional
public class MatiereRepositoryJpa implements IMatiereRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Matiere> findAll() {
		TypedQuery<Matiere> query = em.createQuery("from Matiere", Matiere.class);

		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Matiere find(MatiereId id) {
		return em.find(Matiere.class, id);
	}

	@Override
	public Matiere save(Matiere obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Matiere obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional(readOnly = true)
	public List<Matiere> findAllByFiliere(Filiere filiere) {
		TypedQuery<Matiere> query = em.createQuery(
				"select distinct m.matiere from Module m join m.filiere f where f = :filiere", Matiere.class);

		query.setParameter("filiere", filiere);

		return query.getResultList();
	}

}
