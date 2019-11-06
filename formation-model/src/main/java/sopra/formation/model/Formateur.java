package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("trainer")
public class Formateur extends Personne {
	private int experience;
	private List<Filiere> filieres = new ArrayList<Filiere>();
	private List<Module> modules = new ArrayList<Module>();
	private List<Matiere> competences = new ArrayList<Matiere>();

	public Formateur(String nom, String prenom) {
		super(nom, prenom);
	}

	public Formateur(String nom, String prenom, int experience) {
		super(nom, prenom);
		this.experience = experience;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public List<Filiere> getFilieres() {
		return filieres;
	}

	public void setFilieres(List<Filiere> filieres) {
		this.filieres = filieres;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public List<Matiere> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Matiere> competences) {
		this.competences = competences;
	}

}
