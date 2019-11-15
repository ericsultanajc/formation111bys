package sopra.formation.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sopra.formation.model.Module;
import sopra.formation.repository.IModuleRepository;

@Repository
@Transactional
public class ModuleRepositoryJpa implements IModuleRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Module> findAll() {
		TypedQuery<Module> query = em.createQuery("from Module", Module.class);

		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Module find(Integer id) {
		return em.find(Module.class, id);
	}

	@Override
	public Module save(Module obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(Module obj) {
		em.remove(em.merge(obj));
	}

}
