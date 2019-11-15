package sopra.formation.repository;

import java.util.List;

import sopra.formation.model.Filiere;
import sopra.formation.model.Matiere;
import sopra.formation.model.MatiereId;

public interface IMatiereRepository extends IRepository<Matiere, MatiereId> {
	List<Matiere> findAllByFiliere(Filiere filiere);
}
