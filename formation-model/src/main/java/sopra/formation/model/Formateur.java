package sopra.formation.model;

import java.util.ArrayList;

public class Formateur extends Personne {
	private int experience;
	private ArrayList<Filiere> filieres = new ArrayList<Filiere>();
	private ArrayList<Module> modules = new ArrayList<Module>();
	private ArrayList<Matiere> competences = new ArrayList<Matiere>();

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

	public ArrayList<Filiere> getFilieres() {
		return filieres;
	}

	public void setFilieres(ArrayList<Filiere> filieres) {
		this.filieres = filieres;
	}

	public ArrayList<Module> getModules() {
		return modules;
	}

	public void setModules(ArrayList<Module> modules) {
		this.modules = modules;
	}

	public ArrayList<Matiere> getCompetences() {
		return competences;
	}

	public void setCompetences(ArrayList<Matiere> competences) {
		this.competences = competences;
	}

}
